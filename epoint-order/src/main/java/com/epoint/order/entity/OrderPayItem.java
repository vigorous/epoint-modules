package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:erp_order_pay_item
 */
public class OrderPayItem extends BaseEntity {
    private Long id;

    private Long workOrderId;

    /**
     * 支付金额或者数量。
     * 如使用现金或者现金卡，则这里表示金额。
     * 如使用套餐卡或者储值次卡，则表示次数。
     */
    private Double amount;

    /**
     * 0:现金
     * 1:现金卡
     * 2:套餐卡
     * 3:储值次卡
     * 4:优惠券抵扣（废弃）
     * 5:红包抵扣
     * 6:折扣
     * 7:积分
     * P:优惠券
     */
    private String type;

    /**
     * 如果type是现金卡
     * 套餐卡
     * 储值次卡，则有值
     */
    private Long cardId;

    /**
     * type是
     * 4:优惠券抵扣
     * 5:红包抵扣的时候，保存优惠券，红包的的兑换码。
     */
    private String actCode;

    /**
     * type是积分，表示使用了多少积分
     */
    private Double pointAmount;

    /**
     * type 是6:折扣
     * 表示折扣。0表示折扣
     */
    private Double discount;

    /**
     * 如果type是折扣，则记录哪里商品或者项目打折了。多个项，则使用逗号做分隔符号
     */
    private String ext;

    private Long storeId;

    private Long cardItemId;

    private Long itemId;

    private Long itemType;

    /**
     * 是否赠送的. 1:赠送;0:非赠送
     */
    private Integer isPresented;

    /**
     * 是否预支付. 1:预支付;0:非支付
     */
    private Integer isPrePay;

    /**
     * 是否当面扫码支付。1:是;0:否
     */
    private Integer isScan;

    /**
     * 是否是在线第三方支付 0-否，1-是
     */
    private Integer isOnlineWay;

    /**
     * 只有当is_online_way=1的时候，该字段才有效。将在线支付完成的订单,插入到表erp_check_bill_item中。因小诺洗车使用的是旧版本的微信,支付成功的时候未将支付数据插入到erp_check_bill_item中。0:未完成同步；1:已同步
     */
    private Integer isOnlineSync;

    /**
     * 赠券ID（type=P时有值）
     */
    private Long memberCouponId;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getActCode() {
        return actCode;
    }

    public void setActCode(String actCode) {
        this.actCode = actCode;
    }

    public Double getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(Double pointAmount) {
        this.pointAmount = pointAmount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getCardItemId() {
        return cardItemId;
    }

    public void setCardItemId(Long cardItemId) {
        this.cardItemId = cardItemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemType() {
        return itemType;
    }

    public void setItemType(Long itemType) {
        this.itemType = itemType;
    }

    public Integer getIsPresented() {
        return isPresented;
    }

    public void setIsPresented(Integer isPresented) {
        this.isPresented = isPresented;
    }

    public Integer getIsPrePay() {
        return isPrePay;
    }

    public void setIsPrePay(Integer isPrePay) {
        this.isPrePay = isPrePay;
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

    public Integer getIsOnlineSync() {
        return isOnlineSync;
    }

    public void setIsOnlineSync(Integer isOnlineSync) {
        this.isOnlineSync = isOnlineSync;
    }

    public Long getMemberCouponId() {
        return memberCouponId;
    }

    public void setMemberCouponId(Long memberCouponId) {
        this.memberCouponId = memberCouponId;
    }
}