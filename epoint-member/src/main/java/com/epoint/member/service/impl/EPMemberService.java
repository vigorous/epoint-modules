package com.epoint.member.service.impl;

import com.epoint.car.dao.EPCarBrandMapper;
import com.epoint.car.dao.EPCarModelMapper;
import com.epoint.car.dao.EPCarSeriesMapper;
import com.epoint.car.entity.CarBrand;
import com.epoint.car.entity.CarModel;
import com.epoint.car.entity.CarSeries;
import com.epoint.member.dao.EPMemberStoreInfoMapper;
import com.epoint.member.dao.EPStoreCarLogMapper;
import com.epoint.member.dto.MemberDTO;
import com.epoint.member.entity.MemberStoreInfo;
import com.epoint.member.entity.StoreCarLog;
import com.epoint.member.exception.MemberException;
import com.epoint.member.service.IEPMemberService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * package:com.epoint.member.service.impl
 *
 * @Author smallc on 2017/5/23.
 */
@Service
public class EPMemberService implements IEPMemberService {

    private Logger logger = LogManager.getLogger(EPMemberService.class);

    @Autowired
    private EPStoreCarLogMapper storeCarLogMapper;

    @Autowired
    private EPMemberStoreInfoMapper memberStoreInfoMapper;

    @Autowired
    private EPCarBrandMapper carBrandMapper;

    @Autowired
    private EPCarModelMapper carModelMapper;

    @Autowired
    private EPCarSeriesMapper carSeriesMapper;

    @Override
    public MemberDTO getMemberInfo(Long storeId, Long memberId, String carNo) {

        logger.debug("storeId:{},memberId:{},carNo:{}", storeId, memberId, carNo);

        if (storeId == null) {
            throw new MemberException("门店ID为空");
        }
        if (memberId == null) {
            return new MemberDTO();
            //throw new MemberException("会员ID为空");
        }
        if (!StringUtils.isNotBlank(carNo)) {
            throw new MemberException("车牌号为空");
        }

        //查询门店会员信息
        MemberStoreInfo memberStore = new MemberStoreInfo();
        memberStore.setId(memberId);
        memberStore.setStoreId(storeId);
        MemberStoreInfo memberStoreInfo = memberStoreInfoMapper.selectByCondition(memberStore);
        if (memberStoreInfo == null) {
            //throw new MemberException("无会员信息");
            return new MemberDTO();
        }

        //查询门店会员该车牌号信息
        StoreCarLog storeCarLog = new StoreCarLog();
        storeCarLog.setStoreId(storeId);
        storeCarLog.setMemberId(memberId);
        storeCarLog.setCarNo(carNo);
        List<StoreCarLog> storeCars = storeCarLogMapper.selectByCondition(storeCarLog);
        if (storeCars == null) {
            throw new MemberException("无车辆信息");
        }
        MemberDTO memberDTO = new MemberDTO();
        //查询车品牌、车型、车系
        CarBrand carBrand = new CarBrand();
        CarModel carModel = new CarModel();
        CarSeries carSeries = new CarSeries();
        if (storeCars.size() > 0) {
            if (storeCars.get(0).getCarBrandId() != null) {
                carBrand = carBrandMapper.selectById(storeCars.get(0).getCarBrandId());
                memberDTO.setCarBrand(carBrand);
            }

            if (storeCars.get(0).getCarModelId() != null) {
                carModel = carModelMapper.selectById(storeCars.get(0).getCarModelId());
                memberDTO.setCarModel(carModel);
            }

            if (storeCars.get(0).getCarSeriesId() != null) {
                carSeries = carSeriesMapper.selectById(storeCars.get(0).getCarSeriesId());
                memberDTO.setCarSeries(carSeries);
            }
        }

        memberDTO.setMemberStoreInfo(memberStoreInfo);
        if (storeCars.size() > 0) {
            memberDTO.setStoreCarLog(storeCars.get(0));
        }
        return memberDTO;
    }
}
