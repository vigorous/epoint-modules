package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_insurance_order
 */
public class InsuranceOrder extends BaseEntity {
    private Long id;

    /**
     * 订单主表Id
     */
    private Long workOrderId;

    /**
     * 保单开始时间
     */
    private Date startTime;

    /**
     * 保单到期日期
     */
    private Date endTime;

    /**
     * 保险公司Id (对应erp_insurance_company)
     */
    private Long companyId;

    /**
     * 初登日期
     */
    private Date firstTime;

    /**
     * 营运类型(0:非营运;1:营运)
     */
    private Boolean operateType;

    /**
     * 底盘号
     */
    private String chassisNo;

    /**
     * 门店Id
     */
    private Long storeId;

    /**
     * 客户公司
     */
    private String memberCompany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Boolean getOperateType() {
        return operateType;
    }

    public void setOperateType(Boolean operateType) {
        this.operateType = operateType;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getMemberCompany() {
        return memberCompany;
    }

    public void setMemberCompany(String memberCompany) {
        this.memberCompany = memberCompany;
    }
}