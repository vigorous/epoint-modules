package com.epoint.reception.service.impl;

import com.epoint.car.entity.CarBrand;
import com.epoint.car.entity.CarModel;
import com.epoint.car.entity.CarSeries;
import com.epoint.member.dto.MemberDTO;
import com.epoint.member.entity.MemberStoreInfo;
import com.epoint.member.service.IEPMemberService;
import com.epoint.reception.dao.AppReceptionListMapper;
import com.epoint.reception.dto.ReceptionDetailDTO;
import com.epoint.reception.entity.AppReceptionList;
import com.epoint.reception.exception.ReceptionException;
import com.epoint.reception.service.IReceptionService;
import com.epoint.reception.vo.AppReceptionListVo;
import com.epoint.staff.dao.EPStaffMapper;
import com.epoint.staff.dao.EPStaffStoreMapper;
import com.epoint.staff.entity.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xishengchun on 2017-05-24.
 */
@Service
public class ReceptionService implements IReceptionService {

    private Logger logger = LogManager.getLogger(ReceptionService.class);


    @Autowired
    private IEPMemberService memberService;

    @Autowired
    private AppReceptionListMapper appReceptionListMapper;

    @Autowired
    private EPStaffMapper staffMapper;

    @Autowired
    private EPStaffStoreMapper staffStoreMapper;


    @Override
    public ReceptionDetailDTO getReceptionDetail(Long receptionId) {
        AppReceptionList appReceptionList = appReceptionListMapper.selectById(receptionId);
        if (appReceptionList == null) {
            logger.error("接车单不存在 receptionId:{}", receptionId);
            throw new ReceptionException("接车单不存在");
        }

        Long memberId = appReceptionList.getMemberId();
        Long storeId = appReceptionList.getStoreId();
        String carNo = appReceptionList.getCarNo();
        MemberDTO memberInfo = memberService.getMemberInfo(storeId, memberId, carNo);
        if (memberInfo == null) {
            logger.error("客户不存在 memberId:{} storeId:{} carNo:{}", memberId, storeId, carNo);
            throw new ReceptionException("客户不存在");
        }

        CarBrand carBrand = memberInfo.getCarBrand();
        CarSeries carSeries = memberInfo.getCarSeries();
        CarModel carModel = memberInfo.getCarModel();
        MemberStoreInfo memberStoreInfo = memberInfo.getMemberStoreInfo();

        ReceptionDetailDTO receptionDetailDTO = new ReceptionDetailDTO();
        receptionDetailDTO.setAppReceptionList(appReceptionList);

        if (memberStoreInfo != null) {
            receptionDetailDTO.setMemberName(memberStoreInfo.getName());
            receptionDetailDTO.setMobile(memberStoreInfo.getMobile());
        }

        StringBuffer carBuffer = new StringBuffer();
        if (carBrand != null) {
            carBuffer.append(carBrand.getName());
        }

        if (carSeries != null) {
            carBuffer.append(" ");
            carBuffer.append(carSeries.getName());
        }

        if (carModel != null) {
            carBuffer.append(" ");
            carBuffer.append(carModel.getName());
        }

        receptionDetailDTO.setCarModel(carBuffer.toString());

        Staff staff = staffMapper.selectById(appReceptionList.getStaffId());
        if (staff != null) {
            receptionDetailDTO.setReceptionStaffName(staff.getName());
        }

        // 接车的项目分类
        Long autoworkCategoryId = appReceptionList.getAutoworkCategoryId();
        // TODO

        return receptionDetailDTO;
    }

    @Override
    public AppReceptionList getNoOrderReception(Long memberId) {
        return appReceptionListMapper.selectNoOrderReception(memberId);
    }

    @Override
    public AppReceptionList getReception(Long receptionId) {
        return appReceptionListMapper.selectById(receptionId);
    }

    @Override
    public List<AppReceptionListVo> queryTodayReceptionList(Map<String, Object> map) {
        return appReceptionListMapper.queryTodayReceptionList(map);
    }
}
