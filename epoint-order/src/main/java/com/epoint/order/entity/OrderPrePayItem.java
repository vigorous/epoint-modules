package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:erp_order_pre_pay_item
 */
public class OrderPrePayItem extends BaseEntity {
    private Integer id;

    /**
     * 卡项目ID
     */
    private Integer cardItemId;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 预付类型. 1:会员卡;2:现金;3:微信;4:支付宝;5:银联;6:其他;7:会员卡增送金额;8:优惠卷
     */
    private Integer itemType;

    /**
     * 预付类型为会员卡时,为会员卡ID;预付类型为优惠卷时,为优惠卷ID
     */
    private String itemNote;

    /**
     * 预付金额
     */
    private Double itemAmt;

    /**
     * 是否为赠送金额
     */
    private Integer isPresented;

    /**
     * 是否在线支付。1:是;0:否
     */
    private Integer isScan;

    /**
     * 是否是在线第三方支付 0-否，1-是
     */
    private Integer isOnlineWay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardItemId() {
        return cardItemId;
    }

    public void setCardItemId(Integer cardItemId) {
        this.cardItemId = cardItemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(String itemNote) {
        this.itemNote = itemNote;
    }

    public Double getItemAmt() {
        return itemAmt;
    }

    public void setItemAmt(Double itemAmt) {
        this.itemAmt = itemAmt;
    }

    public Integer getIsPresented() {
        return isPresented;
    }

    public void setIsPresented(Integer isPresented) {
        this.isPresented = isPresented;
    }

    public Integer getIsScan() {
        return isScan;
    }

    public void setIsScan(Integer isScan) {
        this.isScan = isScan;
    }

    public Integer getIsOnlineWay() {
        return isOnlineWay;
    }

    public void setIsOnlineWay(Integer isOnlineWay) {
        this.isOnlineWay = isOnlineWay;
    }
}