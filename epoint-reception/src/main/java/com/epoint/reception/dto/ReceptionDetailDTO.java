package com.epoint.reception.dto;

import com.epoint.reception.entity.AppReceptionList;

import java.util.Date;

/**
 * @author xishengchun on 2017-05-24.
 */
public class ReceptionDetailDTO {

    private AppReceptionList appReceptionList;


    /**
     * 车型
     */
    private String carModel;

    /**
     * 车主姓名
     */
    private String memberName;

    /**
     * 车主联系方式
     */
    private String mobile;


    /**
     * 接车项目
     */
    private String receptionItem;

    /**
     * 接车人员
     */
    private String receptionStaffName;

    /**
     * 预计交车时间
     */
    private Date finishTime;

    public AppReceptionList getAppReceptionList() {
        return appReceptionList;
    }

    public void setAppReceptionList(AppReceptionList appReceptionList) {
        this.appReceptionList = appReceptionList;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getReceptionItem() {
        return receptionItem;
    }

    public void setReceptionItem(String receptionItem) {
        this.receptionItem = receptionItem;
    }

    public String getReceptionStaffName() {
        return receptionStaffName;
    }

    public void setReceptionStaffName(String receptionStaffName) {
        this.receptionStaffName = receptionStaffName;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}
