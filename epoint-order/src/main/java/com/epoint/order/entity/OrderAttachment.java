package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:erp_order_attachment
 */
public class OrderAttachment extends BaseEntity {
    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 所属门店
     */
    private Long storeId;

    /**
     * 附件路径(全路径)
     */
    private String attachmentPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }
}