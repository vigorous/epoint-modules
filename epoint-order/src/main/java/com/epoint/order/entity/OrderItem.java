package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_work_order_item
 */
public class OrderItem extends BaseEntity {
    private Long id;

    private Long workOrderId;

    /**
     * 项目或者商品的id
     */
    private Long itemId;

    /**
     * 1：项目
     * 2：商品3 : 保险
     */
    private String type;

    private Long storeId;

    private Double amount;

    private Double price;

    private Double discount;

    /**
     * 销售人员
     */
    private String saleIds;

    /**
     * 施工人员
     */
    private String workerIds;

    /**
     * 领料人员
     */
    private String pickerIds;

    /**
     * 优惠后的总金额
     */
    private Double itemActualMoney;

    private Double workHour;

    private Double workHourPrice;

    private Long workHourLevelId;

    private String workHourCarRange;

    /**
     * 0:等待中
     * 1:施工中
     * 2:暂停施工
     * 3:施工完成
     */
    private String status;

    private Date beginTime;

    private Date endTime;

    private Long workareaId;

    /**
     * 1：一口价；2：服务费；3：组别费
     */
    private Integer priceType;

    /**
     * 父门店ID
     */
    private Integer parentStoreId;

    /**
     * 是否返工。1:是;0:否
     */
    private Integer rework;

    /**
     * 成本价（单价）
     */
    private Double costPrice;

    /**
     * 施工状态
     */
    private Integer workStatus;

    /**
     * 公司返点
     */
    private Double backCompany;

    /**
     * 客户返点
     */
    private Double backMember;

    /**
     * 销售班组ID
     */
    private String sellerGroupIds;

    /**
     * 施工班组ID
     */
    private String workerGroupIds;

    /**
     * 领料班组
     */
    private String pickerGroupIds;

    /**
     * 会员卡续卡时，单个项目延长的有效期。
     */
    private Date delayValidity;

    /**
     * 质检员
     */
    private String inspectorIds;
    /**
     * 商品出库状态：0-未出库，1-已出库
     */
    private Integer goodsOutStatus;

    /**
     * 质检状态,默认未质检；0：未质检；1：质检中；2：质检结束;
     * 主要用于确认是在质检哪个状态
     */
    private Integer inspectionStatus;

    /**
     * 商品出库人
     */
    private Long goodsOutStaffId;

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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getSaleIds() {
        return saleIds;
    }

    public void setSaleIds(String saleIds) {
        this.saleIds = saleIds;
    }

    public String getWorkerIds() {
        return workerIds;
    }

    public void setWorkerIds(String workerIds) {
        this.workerIds = workerIds;
    }

    public String getPickerIds() {
        return pickerIds;
    }

    public void setPickerIds(String pickerIds) {
        this.pickerIds = pickerIds;
    }

    public Double getItemActualMoney() {
        return itemActualMoney;
    }

    public void setItemActualMoney(Double itemActualMoney) {
        this.itemActualMoney = itemActualMoney;
    }

    public Double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(Double workHour) {
        this.workHour = workHour;
    }

    public Double getWorkHourPrice() {
        return workHourPrice;
    }

    public void setWorkHourPrice(Double workHourPrice) {
        this.workHourPrice = workHourPrice;
    }

    public Long getWorkHourLevelId() {
        return workHourLevelId;
    }

    public void setWorkHourLevelId(Long workHourLevelId) {
        this.workHourLevelId = workHourLevelId;
    }

    public String getWorkHourCarRange() {
        return workHourCarRange;
    }

    public void setWorkHourCarRange(String workHourCarRange) {
        this.workHourCarRange = workHourCarRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getWorkareaId() {
        return workareaId;
    }

    public void setWorkareaId(Long workareaId) {
        this.workareaId = workareaId;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public Integer getParentStoreId() {
        return parentStoreId;
    }

    public void setParentStoreId(Integer parentStoreId) {
        this.parentStoreId = parentStoreId;
    }

    public Integer getRework() {
        return rework;
    }

    public void setRework(Integer rework) {
        this.rework = rework;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public Double getBackCompany() {
        return backCompany;
    }

    public void setBackCompany(Double backCompany) {
        this.backCompany = backCompany;
    }

    public Double getBackMember() {
        return backMember;
    }

    public void setBackMember(Double backMember) {
        this.backMember = backMember;
    }

    public String getSellerGroupIds() {
        return sellerGroupIds;
    }

    public void setSellerGroupIds(String sellerGroupIds) {
        this.sellerGroupIds = sellerGroupIds;
    }

    public String getWorkerGroupIds() {
        return workerGroupIds;
    }

    public void setWorkerGroupIds(String workerGroupIds) {
        this.workerGroupIds = workerGroupIds;
    }

    public String getPickerGroupIds() {
        return pickerGroupIds;
    }

    public void setPickerGroupIds(String pickerGroupIds) {
        this.pickerGroupIds = pickerGroupIds;
    }

    public Date getDelayValidity() {
        return delayValidity;
    }

    public void setDelayValidity(Date delayValidity) {
        this.delayValidity = delayValidity;
    }

    public String getInspectorIds() {
        return inspectorIds;
    }

    public void setInspectorIds(String inspectorIds) {
        this.inspectorIds = inspectorIds;
    }

    public Integer getGoodsOutStatus() {
        return goodsOutStatus;
    }

    public void setGoodsOutStatus(Integer goodsOutStatus) {
        this.goodsOutStatus = goodsOutStatus;
    }

    public Integer getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(Integer inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public Long getGoodsOutStaffId() {
        return goodsOutStaffId;
    }

    public void setGoodsOutStaffId(Long goodsOutStaffId) {
        this.goodsOutStaffId = goodsOutStaffId;
    }
}