package com.epoint.coupon.service.impl;

import com.epoint.coupon.dao.CouponMapper;
import com.epoint.coupon.dao.CouponShareTaskMapper;
import com.epoint.coupon.dao.MemberCouponMapper;
import com.epoint.coupon.dao.StoreCouponMapper;
import com.epoint.coupon.dto.MyCoupon;
import com.epoint.coupon.dto.StoreCouponDTO;
import com.epoint.coupon.entity.Coupon;
import com.epoint.coupon.entity.CouponShareTask;
import com.epoint.coupon.entity.MemberCoupon;
import com.epoint.coupon.entity.StoreCoupon;
import com.epoint.coupon.enums.CouponConstant;
import com.epoint.coupon.exception.CouponException;
import com.epoint.coupon.service.ICouponService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chiang on 2017/4/13.
 */
@Component
public class CouponService implements ICouponService{
    private final static Logger LOGGER = LogManager.getLogger(CouponService.class.getName());

    @Resource
    private CouponMapper couponMapper;

    @Resource
    private MemberCouponMapper memberCouponMapper;

    @Resource
    private CouponShareTaskMapper couponShareTaskMapper;

    @Resource
    private StoreCouponMapper storeCouponMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int sendCoupon(MemberCoupon memberCoupon) {
        if (memberCoupon == null || memberCoupon.getCouponId() == null){
            LOGGER.warn("参数异常");
            throw new CouponException("参数异常");
        }
        Coupon coupon = couponMapper.selectById(memberCoupon.getCouponId());
        if (coupon == null){
            LOGGER.warn("优惠券不存在 coupon id:{}",memberCoupon.getCouponId());
            throw new CouponException("优惠券不存在");
        }
        //(一)校验券的有效性(是否开启,是否发完,是否过期)
          if (!valid(coupon,memberCoupon.getReceiveStoreId())){
              throw new CouponException("优惠券无效");
          }

        //(二)插入领取记录
        memberCoupon.setCouponName(coupon.getName());
        //赠券创建门店ID
        memberCoupon.setCouponStoreId(coupon.getStoreId());
        memberCoupon.setCouponContent(coupon.getContent());
        memberCoupon.setCouponMoney(coupon.getCouponMoney());
        memberCoupon.setItemId(coupon.getItemId());
        memberCoupon.setCouponType(coupon.getType());
        memberCoupon.setReceiveTime(new Date());//领取时间
        memberCoupon.setCreateTime(new Date());
        if (memberCoupon.getReceiveType() != CouponConstant.ReceiveType.ERP_DIRECT_SEND.getCode()){
            memberCoupon.setStartTime(coupon.getStartTime());
            memberCoupon.setEndTime(coupon.getEndTime());
        }
        int r = memberCouponMapper.insert(memberCoupon);
        if (r <= 0) {//回滚
            LOGGER.warn("插入领取记录异常 coupon id:{}",coupon.getId());
            throw new CouponException("领取优惠券异常");
        }

        //(三)更新领取数量
        //coupon.setReceiveNum(coupon.getReceiveNum() + 1);
        //r = r + couponMapper.updateById(coupon);
        r = couponMapper.updateReceiveNum(coupon.getId(),1);
        if (r <= 0) {//回滚
            LOGGER.warn("更新领取数量异常 coupon id:{}",coupon.getId());
            throw new CouponException("更新领取数量异常");
        }

        r = storeCouponMapper.updateReceiveNum(coupon.getId(),memberCoupon.getReceiveStoreId(),1);
        if (r <= 0) {//回滚
            LOGGER.warn("更新领取数量异常 coupon_id:{},apply_store_id:{}",coupon.getId(),memberCoupon.getReceiveStoreId());
            throw new CouponException("更新领取数量异常");
        }

        Long taskId = memberCoupon.getTaskId();
        if (taskId != null){
            CouponShareTask task = new CouponShareTask();
            task.setStatus(CouponConstant.TaskStatus.RECEIVED_COUPON.getCode());
            task.setId(taskId);
            task.setUpdateTime(new Date());
            r = couponShareTaskMapper.updateById(task);

            if (r <= 0) {//回滚
                LOGGER.warn("更新任务状态异常 coupon id:{}",coupon.getId());
                throw new CouponException("更新任务状态异常");
            }
        }

        return r;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int usedCoupon(MemberCoupon memberCoupon, Double orderAmt) {
        if (memberCoupon == null || memberCoupon.getId() == null){
            LOGGER.warn("参数异常");
            throw new CouponException("参数异常");
        }
        //(一) 判断是否过期，是否已使用
        MemberCoupon mc = memberCouponMapper.selectById(memberCoupon.getId());
        if (mc == null){
            LOGGER.warn("优惠券不存在 member coupon id:{}",memberCoupon.getId());
            throw new CouponException("优惠券不存在");
        }
        //1.已使用
        if (CouponConstant.UseStatus.isUsed(mc.getStatus())){
            LOGGER.warn("优惠券已被使用 member coupon id:{}",mc.getId());
            throw new CouponException("优惠券已被使用");
        }


        //2.未到使用期
        Date startDate = mc.getStartTime();
        if (startDate != null && startDate.getTime() > System.currentTimeMillis()){
            LOGGER.warn("优惠券不在使用期暂时不能使用 member coupon id:{}",mc.getId());
            throw new CouponException("优惠券不在使用期暂时不能使用");
        }
        Date endDate = mc.getEndTime();
        //3.过期了
        if (endDate != null && endDate.getTime() < System.currentTimeMillis()){
            LOGGER.warn("优惠券已过期不能使用 member coupon id:{}",mc.getId());
            throw new CouponException("优惠券已过期不能使用");
        }

        //更新使用门店,使用状态
        MemberCoupon updatedMc = new MemberCoupon();
        Date now = new Date();
        updatedMc.setId(mc.getId());
        updatedMc.setUseStoreId(memberCoupon.getUseStoreId());
        updatedMc.setUseTime(now);
        updatedMc.setStatus(CouponConstant.UseStatus.USED.getCode());
        updatedMc.setUpdateTime(now);
        int r = memberCouponMapper.updateById(updatedMc);
        if (r <= 0) {//回滚
            LOGGER.warn("更新优惠券使用状态异常 member coupon id:{}",mc.getId());
            throw new CouponException("更新优惠券使用状态异常");
        }

        StoreCoupon storeCoupon = new StoreCoupon();
        storeCoupon.setApplyStoreId(mc.getReceiveStoreId());
        storeCoupon.setCouponId(mc.getCouponId());
        storeCoupon.setUseNum(1);
        storeCoupon.setOrderMoney(orderAmt);

        r = storeCouponMapper.updateUseNumAndOrderAmt(storeCoupon);
        if (r <= 0) {//回滚
            LOGGER.warn("更新优惠券使用数量异常 coupon_id:{},applyStoreId:{}",storeCoupon.getCouponId(),storeCoupon.getApplyStoreId());
            throw new CouponException("更新优惠券使用数量异常");
        }

        Coupon coupon = new Coupon();
        coupon.setId(mc.getCouponId());
        coupon.setUseNum(1);
        coupon.setOrderMoney(orderAmt);
        coupon.setUpdateTime(new Date());
        r = couponMapper.updateUseNumAndOrderAmt(coupon);
        if (r <= 0) {//回滚
            LOGGER.warn("更新优惠券使用数量异常 member coupon id:{}",mc.getId());
            throw new CouponException("更新优惠券使用数量异常");
        }
        return r;
    }



    public int useCoupon(MemberCoupon memberCoupon) {
        if (memberCoupon == null || memberCoupon.getId() == null){
            LOGGER.warn("参数异常");
            throw new CouponException("参数异常");
        }
        //(一) 判断是否过期，是否已使用
        MemberCoupon mc = memberCouponMapper.selectById(memberCoupon.getId());
        if (mc == null){
            LOGGER.warn("优惠券不存在 member coupon id:{}",memberCoupon.getId());
            throw new CouponException("优惠券不存在");
        }

        //1.正在使用
        if (CouponConstant.UseStatus.isUsing(mc.getStatus())){
            LOGGER.warn("优惠券正在使用 member coupon id:{}",mc.getId());
            throw new CouponException("优惠券正在使用");
        }
        //2.已使用
        if (CouponConstant.UseStatus.isUsed(mc.getStatus())){
            LOGGER.warn("优惠券已被使用 member coupon id:{}",mc.getId());
            throw new CouponException("优惠券已被使用");
        }


        //3.未到使用期
        Date startDate = mc.getStartTime();
        if (startDate != null && startDate.getTime() > System.currentTimeMillis()){
            LOGGER.warn("优惠券不在使用期暂时不能使用 member coupon id:{}",mc.getId());
            throw new CouponException("优惠券不在使用期暂时不能使用");
        }
        Date endDate = mc.getEndTime();
        //4.过期了
        if (endDate != null && endDate.getTime() < System.currentTimeMillis()){
            LOGGER.warn("优惠券已过期不能使用 member coupon id:{}",mc.getId());
            throw new CouponException("优惠券已过期不能使用");
        }

        //更新使用门店,使用状态
        Date now = new Date();
        MemberCoupon updatedMc = new MemberCoupon();
        updatedMc.setId(memberCoupon.getId());//参数
        updatedMc.setUseTime(now);
        updatedMc.setUseStoreId(memberCoupon.getUseStoreId());//参数
        updatedMc.setStatus(CouponConstant.UseStatus.USING.getCode());
        updatedMc.setUpdateTime(now);
        return memberCouponMapper.updateById(updatedMc);

    }

    @Override
    public int cancelUseCoupon(Long memberCouponId) {

        //(一) 判断是否过期，是否已使用
        MemberCoupon mc = memberCouponMapper.selectById(memberCouponId);
        if (mc == null){
            LOGGER.warn("优惠券不存在 member coupon id:{}",memberCouponId);
            throw new CouponException("优惠券不存在");
        }

        //1.已使用
        if (CouponConstant.UseStatus.isUsed(mc.getStatus())){
            LOGGER.warn("优惠券已被使用 member coupon id:{}",mc.getId());
            throw new CouponException("优惠券已被使用");
        }

        //更新优惠券为未使用状态
        Date now = new Date();
        MemberCoupon updatedMc = new MemberCoupon();
        updatedMc.setId(memberCouponId);//参数
        updatedMc.setStatus(CouponConstant.UseStatus.NOT_USED.getCode());
        updatedMc.setUpdateTime(now);
        return memberCouponMapper.updateById(updatedMc);
    }

    @Override
    public List<MemberCoupon> selectMemberCouponByMemberId(Long memberId,Long storeId) {
        List<MemberCoupon> couponList = new ArrayList<>();
        //1.查询改会员的所有优惠券(有效的)
        MemberCoupon mc = new MemberCoupon();
        mc.setStatus(CouponConstant.UseStatus.NOT_USED.getCode());
        mc.setMemberId(memberId);
        mc.setUseTime(new Date());
        List<MemberCoupon> memberCouponList = memberCouponMapper.selectMemberCoupon(mc);
        if (memberCouponList == null || memberCouponList.isEmpty()){
            return couponList;
        }
        //2.查询改门店的所有优惠券(不过期的)
        Coupon c = new Coupon();
        c.setStoreId(storeId);//当前门店
        c.setCreateTime(new Date());//当前时间
        List<Coupon> storeCouponList = couponMapper.selectCoupon(c);
        if (storeCouponList == null || storeCouponList.isEmpty()){
            return couponList;
        }
        //3.进行匹配数据
//        for (MemberCoupon memberCoupon:memberCouponList){
//            //未到使用期
//            Date startDate = memberCoupon.getStartTime();
//            if (startDate != null && startDate.getTime() > mc.getUseTime().getTime()){
//                LOGGER.debug("优惠券不在使用期暂时不能使用 member coupon id:{}",mc.getId());
//                continue;
//            }
//            Date endDate = memberCoupon.getEndTime();
//            //过期了
//            if (endDate != null && endDate.getTime() < mc.getUseTime().getTime()){
//                LOGGER.debug("优惠券已过期不能使用 member coupon id:{}",mc.getId());
//                continue;
//            }
//            for (Coupon sc:storeCouponList){
//                if (memberCoupon.getCouponId().longValue() == sc.getId()){
//                    couponList.add(memberCoupon);
//                    break;
//                }
//            }
//        }
        memberCouponList.parallelStream().filter(memberCoupon -> {
            Date startDate = memberCoupon.getStartTime();
            if (startDate != null && startDate.getTime() > mc.getUseTime().getTime()){
                LOGGER.debug("优惠券不在使用期暂时不能使用 member coupon id:{}",mc.getId());
                return false;
            }
            Date endDate = memberCoupon.getEndTime();
            //过期了
            if (endDate != null && endDate.getTime() < mc.getUseTime().getTime()){
                LOGGER.debug("优惠券已过期不能使用 member coupon id:{}",mc.getId());
                return false;
            }
            return true;
        }).forEach(memberCoupon -> {

            boolean canUse = storeCouponList.stream().anyMatch(sc -> memberCoupon.getCouponId().longValue() == sc.getId());
            if (canUse){couponList.add(memberCoupon);}
        });
        return couponList;
    }

    private boolean valid(Coupon coupon,Long storeId){
        StoreCoupon storeCoupon = storeCouponMapper.selectByStoreIdAndCouponId(coupon.getId(),storeId);
        //1.状态
        if (CouponConstant.Status.isClosed(storeCoupon.getCouponStatus())){
            LOGGER.warn("优惠券已停用 coupon id:{}",coupon.getId());
            return false;
        }

        //2.有效期
        Date endDate = coupon.getEndTime();
        if (endDate != null && endDate.getTime() < System.currentTimeMillis()){
            LOGGER.warn("优惠券已过期 coupon id:{}",coupon.getId());
            return false;
        }

        //3. 是否发完
        if (coupon.getReceiveNum() == null){
            coupon.setReceiveNum(0);
        }
        if (coupon.getPublishNum() != null && coupon.getPublishNum() > CouponConstant.Unlimited.YES.getCode() && coupon.getPublishNum() <= coupon.getReceiveNum()){
            LOGGER.warn("优惠券已发完 coupon id:{}",coupon.getId());
            return false;
        }

        return true;
    }

    @Override
    public List<Coupon> selectCouponByStoreId(Long storeId) {
        List<Coupon> couponList = new ArrayList<>();
        Coupon c = new Coupon();
        c.setStoreId(storeId);//当前门店
        c.setCreateTime(new Date());//当前时间
        List<Coupon> storeCouponList = couponMapper.selectCoupon(c);
        if (storeCouponList == null || storeCouponList.isEmpty()) {
            return couponList;
        }
        /*for (Coupon coupon:storeCouponList){
            if (valid(coupon,storeId)){
                couponList.add(coupon);
            }
        }*/
        storeCouponList.parallelStream().filter(coupon -> valid(coupon,storeId)).forEach(coupon -> couponList.add(coupon));
        return couponList;
    }

    @Override
    public MemberCoupon selectMemberCouponById(Long id) {
        return memberCouponMapper.selectById(id);
    }

    @Override
    public List<MyCoupon> myCoupon(Long memberId, Long storeId, Long parentStoreId) {
        List<MyCoupon> myCouponList = new ArrayList<>();
        List<MyCoupon> myCouponList1 = memberCouponMapper.selectMemberCouponByMemberId(memberId,storeId);
        if (myCouponList1 != null){
            myCouponList.addAll(myCouponList1);
        }
        if (parentStoreId == null || parentStoreId == -1 || parentStoreId == storeId){
            return myCouponList;
        }
        List<MyCoupon> myCouponList2 = memberCouponMapper.selectMemberCouponByMemberId(memberId,parentStoreId);
        if (myCouponList2 != null){
            myCouponList.addAll(myCouponList2);
        }
        /*for (MyCoupon coupon : myCouponList){
            List<StoreCouponDTO> storeCouponList = storeCouponMapper.queryApplyStoreByCouponId(coupon.getCouponId());
            coupon.setStoreCouponDTOList(storeCouponList);
        }*/
        return myCouponList;
    }

    @Override
    public List<StoreCouponDTO> canUseStore(Long couponId) {
        List<StoreCouponDTO> storeCouponList = storeCouponMapper.queryAllApplyStoreByCouponId(couponId);
        return storeCouponList;
    }

    @Override
    public Coupon selectById(Long id) {
        return couponMapper.selectById(id);
    }
}
