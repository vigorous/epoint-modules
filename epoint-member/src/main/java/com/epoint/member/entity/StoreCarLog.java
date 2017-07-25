package com.epoint.member.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_store_car_log
 */
public class StoreCarLog extends BaseEntity {
    private Long id;

    /**
     * 车牌号
     */
    private String carNo;

    private Long memberId;

    private Long storeId;

    private Long parentStoreId;

    /**
     * 品牌id
     */
    private Long carBrandId;

    /**
     * 车系id
     */
    private Long carSeriesId;

    /**
     * 车型号id
     */
    private Long carModelId;

    /**
     * vin码
     */
    private String vehicleId;

    /**
     * 购买时间
     */
    private Date buyTime;

    /**
     * 发动机号
     */
    private String engineNo;

    /**
     * 公里数
     */
    private String kilometers;

    /**
     * 保险日期
     */
    private Date insuranceDate;

    /**
     * 保险过期时间
     */
    private Date insuranceExpireTime;

    /**
     * 保险公司
     */
    private String insuranceCompany;

    /**
     * 上次保养里程 单位千米
     */
    private Double preMaintainMileage;

    /**
     * 下次保养里程 单位千米
     */
    private Double nextMaintainMileage;

    private Date preMaintainTime;

    private Date nextMaintainTime;

    /**
     * 年检到期时间
     */
    private Date annualExpireTime;

    /**
     * 轮胎品牌
     */
    private String tireBrand;

    /**
     * 轮胎更新时间
     */
    private Date tireChangeTime;

    /**
     * 行驶证号
     */
    private String carLicenseNo;

    /**
     * 车辆拥有类型 个人 公司
     */
    private String ownType;

    /**
     * 车辆状态，0：正常，1：删除
     */
    private Integer status;

    /**
     *  公车 的 公司名称
     */
    private String ownName;

    private String carBrandName;

    private String carRemark;

    /**
     * 车颜色
     */
    private String carColor;

    /**
     * 底盘号
     */
    private String chassisNo;

    /**
     * 初登时间
     */
    private Date firstTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getParentStoreId() {
        return parentStoreId;
    }

    public void setParentStoreId(Long parentStoreId) {
        this.parentStoreId = parentStoreId;
    }

    public Long getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(Long carBrandId) {
        this.carBrandId = carBrandId;
    }

    public Long getCarSeriesId() {
        return carSeriesId;
    }

    public void setCarSeriesId(Long carSeriesId) {
        this.carSeriesId = carSeriesId;
    }

    public Long getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Long carModelId) {
        this.carModelId = carModelId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public Date getInsuranceExpireTime() {
        return insuranceExpireTime;
    }

    public void setInsuranceExpireTime(Date insuranceExpireTime) {
        this.insuranceExpireTime = insuranceExpireTime;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Double getPreMaintainMileage() {
        return preMaintainMileage;
    }

    public void setPreMaintainMileage(Double preMaintainMileage) {
        this.preMaintainMileage = preMaintainMileage;
    }

    public Double getNextMaintainMileage() {
        return nextMaintainMileage;
    }

    public void setNextMaintainMileage(Double nextMaintainMileage) {
        this.nextMaintainMileage = nextMaintainMileage;
    }

    public Date getPreMaintainTime() {
        return preMaintainTime;
    }

    public void setPreMaintainTime(Date preMaintainTime) {
        this.preMaintainTime = preMaintainTime;
    }

    public Date getNextMaintainTime() {
        return nextMaintainTime;
    }

    public void setNextMaintainTime(Date nextMaintainTime) {
        this.nextMaintainTime = nextMaintainTime;
    }

    public Date getAnnualExpireTime() {
        return annualExpireTime;
    }

    public void setAnnualExpireTime(Date annualExpireTime) {
        this.annualExpireTime = annualExpireTime;
    }

    public String getTireBrand() {
        return tireBrand;
    }

    public void setTireBrand(String tireBrand) {
        this.tireBrand = tireBrand;
    }

    public Date getTireChangeTime() {
        return tireChangeTime;
    }

    public void setTireChangeTime(Date tireChangeTime) {
        this.tireChangeTime = tireChangeTime;
    }

    public String getCarLicenseNo() {
        return carLicenseNo;
    }

    public void setCarLicenseNo(String carLicenseNo) {
        this.carLicenseNo = carLicenseNo;
    }

    public String getOwnType() {
        return ownType;
    }

    public void setOwnType(String ownType) {
        this.ownType = ownType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getCarRemark() {
        return carRemark;
    }

    public void setCarRemark(String carRemark) {
        this.carRemark = carRemark;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }
}