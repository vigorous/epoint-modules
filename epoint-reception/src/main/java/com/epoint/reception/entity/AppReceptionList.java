package com.epoint.reception.entity;

import com.epoint.entity.BaseEntity;

import java.util.Date;

/**
 * 表名:app_reception_list
 */
public class AppReceptionList extends BaseEntity {
    private Long id;

    private String carNo;

    private Long memberId;

    private Long autoworkCategoryId;

    /**
     * 故障描述
     */
    private String description;

    private Long staffId;

    private Long storeId;

    private String carKeyNo;
    
    private Integer status;

    private Date createTime;

    private Long assignOrderStaffId;

    private Date assignOrderTime;

    private String bookTagName;

    /**
     * 预约ID
     */
    private Long bookInfoId;

    /**
     * 验车ID
     */
    private Long carCheckId;

    /**
     * 指派的验车人
     */
    private Long assignCheckStaffId;

    /**
     * 指派验车时间
     */
    private Date assignCheckTime;

    private Long carId;
    
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

    public Long getAutoworkCategoryId() {
        return autoworkCategoryId;
    }

    public void setAutoworkCategoryId(Long autoworkCategoryId) {
        this.autoworkCategoryId = autoworkCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

	public String getCarKeyNo() {
		return carKeyNo;
	}

	public void setCarKeyNo(String carKeyNo) {
		this.carKeyNo = carKeyNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getBookTagName() {
        return bookTagName;
    }

    public void setBookTagName(String bookTagName) {
        this.bookTagName = bookTagName;
    }

    public Long getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Long bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public Long getCarCheckId() {
        return carCheckId;
    }

    public void setCarCheckId(Long carCheckId) {
        this.carCheckId = carCheckId;
    }

    public Long getAssignCheckStaffId() {
        return assignCheckStaffId;
    }

    public void setAssignCheckStaffId(Long assignCheckStaffId) {
        this.assignCheckStaffId = assignCheckStaffId;
    }

    public Date getAssignCheckTime() {
        return assignCheckTime;
    }

    public void setAssignCheckTime(Date assignCheckTime) {
        this.assignCheckTime = assignCheckTime;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}