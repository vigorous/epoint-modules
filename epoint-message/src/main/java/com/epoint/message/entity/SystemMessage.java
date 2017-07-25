package com.epoint.message.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:erp_system_message
 */
public class SystemMessage extends BaseEntity {
    private Long id;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息类型:1-订单派工，2-领料派工，3-指派验车，4-指派开单，5-指派质检
     */
    private Short type;

    /**
     * 员工ID，消息接受者
     */
    private Long staffId;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 消息状态
     * 0:未读取
     * 1:已读取
     * 2:删除
     */
    private Short status;

    /**
     * 订单id
     */
    private Long dataId;

    private String carNo;

    /**
     * 扩展字段。json格式
     */
    private String extras;

    private Long memberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

}