package com.epoint.carcheck.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 表名:erp_car_check
 */
public class EPCarCheck extends BaseEntity {
    private Integer id;

    /**
     * 门店ID
     */
    private Integer storeId;

    /**
     * 父门店ID
     */
    private Integer parentStoreId;

    /**
     * 验车技师ID
     */
    private Integer checkerStaffId;

    /**
     * 会员(车主)ID
     */
    private Integer memberId;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 车辆ID
     */
    private Integer carId;

    /**
     * 车架号
     */
    private String vin;

    /**
     * 油表刻度
     */
    private Double oilMeter;

    /**
     * 行驶里程
     */
    private Integer tripDistance;

    /**
     * 验车总体描述
     */
    private String checkSumary;

    /**
     * 验车状态. 0:未验车;1:异常;2:正常
     */
    private Integer checkStatus;

    /**
     * 车主是否确认。0:未确认;1:确认异常;2:确认正常
     */
    private Integer confirmStatus;

    /**
     * 创建人ID
     */
    private Integer creator;

    /**
     * 车主手机
     */
    private String mobile;

    /**
     * 是已发送短信. 1:是；0：未发送；
     */
    private Integer isSendSms;

    /**
     * 验车班组ID
     */
    private Integer checkerStaffGroupId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 指派开单员工ID
     */
    private Long assignOrderStaffId;

    /**
     * 指派开单时间
     */
    private Date assignOrderTime;

    /**
     * 预约单id,可能为空
     */
    private Long bookInfoId;

    /**
     * 接车单id
     */
    private Long receptionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getParentStoreId() {
        return parentStoreId;
    }

    public void setParentStoreId(Integer parentStoreId) {
        this.parentStoreId = parentStoreId;
    }

    public Integer getCheckerStaffId() {
        return checkerStaffId;
    }

    public void setCheckerStaffId(Integer checkerStaffId) {
        this.checkerStaffId = checkerStaffId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Double getOilMeter() {
        return oilMeter;
    }

    public void setOilMeter(Double oilMeter) {
        this.oilMeter = oilMeter;
    }

    public Integer getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(Integer tripDistance) {
        this.tripDistance = tripDistance;
    }

    public String getCheckSumary() {
        return checkSumary;
    }

    public void setCheckSumary(String checkSumary) {
        this.checkSumary = checkSumary;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getIsSendSms() {
        return isSendSms;
    }

    public void setIsSendSms(Integer isSendSms) {
        this.isSendSms = isSendSms;
    }

    public Integer getCheckerStaffGroupId() {
        return checkerStaffGroupId;
    }

    public void setCheckerStaffGroupId(Integer checkerStaffGroupId) {
        this.checkerStaffGroupId = checkerStaffGroupId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getAssignOrderStaffId() {
        return assignOrderStaffId;
    }

    public void setAssignOrderStaffId(Long assignOrderStaffId) {
        this.assignOrderStaffId = assignOrderStaffId;
    }

    public Date getAssignOrderTime() {
        return assignOrderTime;
    }

    public void setAssignOrderTime(Date assignOrderTime) {
        this.assignOrderTime = assignOrderTime;
    }

    public Long getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Long bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public Long getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(Long receptionId) {
        this.receptionId = receptionId;
    }
}