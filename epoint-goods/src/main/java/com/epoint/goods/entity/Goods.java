package com.epoint.goods.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_goods
 */
public class Goods extends BaseEntity {
    private Long id;

    private String name;

    /**
     * 商品编号
     */
    private String goodsNo;

    /**
     * 商品型号
     */
    private String model;

    /**
     * 商品简称
     */
    private String goodsShort;

    /**
     * 单位
     */
    private String unit;

    /**
     * 条形码
     */
    private String goodsCode;

    /**
     * 0:非配件;1:是配件
     */
    private Boolean isParts;

    /**
     * 是否内部使用
     */
    private Boolean isInside;

    /**
     * 商品品牌Id
     */
    private Long brandId;

    private Long supplierId;

    /**
     * 商品分类Id
     */
    private Long goodsCategoryId;

    private Long storeId;

    /**
     * 0
正常1删除
     */
    private String status;

    private String image;

    private String flag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 库存上架标识
     */
    private Boolean isGrounding;

    /**
     * 其他系统商品id(导入时，其他系统商品id)
     */
    private String otherSystemGoodsId;

    private String spellShort;

    /**
     * 商品编码
     */
    private String goodsCoding;

    /**
     * 是否临时采购，0：否，1是
     */
    private Long isTempPurchase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGoodsShort() {
        return goodsShort;
    }

    public void setGoodsShort(String goodsShort) {
        this.goodsShort = goodsShort;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public Boolean getIsParts() {
        return isParts;
    }

    public void setIsParts(Boolean isParts) {
        this.isParts = isParts;
    }

    public Boolean getIsInside() {
        return isInside;
    }

    public void setIsInside(Boolean isInside) {
        this.isInside = isInside;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Long goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIsGrounding() {
        return isGrounding;
    }

    public void setIsGrounding(Boolean isGrounding) {
        this.isGrounding = isGrounding;
    }

    public String getOtherSystemGoodsId() {
        return otherSystemGoodsId;
    }

    public void setOtherSystemGoodsId(String otherSystemGoodsId) {
        this.otherSystemGoodsId = otherSystemGoodsId;
    }

    public String getSpellShort() {
        return spellShort;
    }

    public void setSpellShort(String spellShort) {
        this.spellShort = spellShort;
    }

    public String getGoodsCoding() {
        return goodsCoding;
    }

    public void setGoodsCoding(String goodsCoding) {
        this.goodsCoding = goodsCoding;
    }

    public Long getIsTempPurchase() {
        return isTempPurchase;
    }

    public void setIsTempPurchase(Long isTempPurchase) {
        this.isTempPurchase = isTempPurchase;
    }
}