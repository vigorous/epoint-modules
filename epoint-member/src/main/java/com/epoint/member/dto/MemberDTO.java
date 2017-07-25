package com.epoint.member.dto;

import com.epoint.car.entity.CarBrand;
import com.epoint.car.entity.CarModel;
import com.epoint.car.entity.CarSeries;
import com.epoint.member.entity.MemberStoreInfo;
import com.epoint.member.entity.StoreCarLog;

/**
 * package:com.epoint.member.dto
 *
 * @Author smallc on 2017/5/23.
 */
public class MemberDTO {
    /**
     * 门店会员信息
     */
    private MemberStoreInfo memberStoreInfo;
    /**
     * 门店会员车辆信息
     */
    private StoreCarLog storeCarLog;

    /**
     * 车型
     */
    private CarModel carModel;

    /**
     * 车品牌
     */
    private CarBrand carBrand;

    /**
     * 车系
     */
    private CarSeries carSeries;

    public MemberStoreInfo getMemberStoreInfo() {
        return memberStoreInfo;
    }

    public void setMemberStoreInfo(MemberStoreInfo memberStoreInfo) {
        this.memberStoreInfo = memberStoreInfo;
    }

    public StoreCarLog getStoreCarLog() {
        return storeCarLog;
    }

    public void setStoreCarLog(StoreCarLog storeCarLog) {
        this.storeCarLog = storeCarLog;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public CarSeries getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(CarSeries carSeries) {
        this.carSeries = carSeries;
    }
}
