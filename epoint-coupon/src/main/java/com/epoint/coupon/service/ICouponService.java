package com.epoint.coupon.service;

import com.epoint.coupon.dto.MyCoupon;
import com.epoint.coupon.dto.StoreCouponDTO;
import com.epoint.coupon.entity.Coupon;
import com.epoint.coupon.entity.MemberCoupon;

import java.util.List;

/**
 * Created by chiang on 2017/4/13.
 */
public interface ICouponService {
    /**
     * 发放或领取优惠券(ERP端直接发券、微信端领取券使用该接口)
     * @param coupon(memberId,couponId,mobile,receiveStoreId 必填)
     * @return
     */
    int sendCoupon(MemberCoupon coupon);

    /**
     * 使用优惠券(ERP订单结算成功、微信端订单支付成功使用该接口.支付成功才算使用成功)
     * @param coupon(id,useStoreId 必传)
     * @param orderAmt 关联订单金额
     * @return
     */
    int usedCoupon(MemberCoupon coupon,Double orderAmt);

    /**
     * 使用优惠券(ERP下单、微信下单使用该接口 只修改状态为使用中)
     * @param coupon(id,useStoreId 必传)
     * @return
     */
    int useCoupon(MemberCoupon coupon);

    /**
     * 取消订单上使用的优惠券
     * @param memberCouponId
     * @return
     */
    int cancelUseCoupon(Long memberCouponId);

    /**
     * 根据查询可用的优惠券
     * @param memberId 会员ID
     * @param storeId 当前门店ID
     * @return 返回会员在当前门店可用的优惠券
     */
    List<MemberCoupon> selectMemberCouponByMemberId(Long memberId,Long storeId);

    /**
     * 查询门店有效的优惠券
     * @param storeId 当前门店ID
     * @return 返回会员在当前门店可用的优惠券
     */
    List<Coupon> selectCouponByStoreId(Long storeId);

    /**
     * 根据会员领取的券id(会员券表)查询会员券信息
     * @param id
     * @return
     */
    MemberCoupon selectMemberCouponById(Long id);

    /**
     * 我的券包数据列表
     * @param memberId 会员ID
     * @param storeId 当前门店
     * @param parentStoreId 父门店
     * @return
     */
    List<MyCoupon> myCoupon(Long memberId, Long storeId, Long parentStoreId);

    /**
     * 优惠券可使用门店
     * @param couponId
     * @return
     */
    List<StoreCouponDTO> canUseStore(Long couponId);

    /**
     * 根据券id查询券的设置信息
     * @param id
     * @return
     */
    Coupon selectById(Long id);

}
