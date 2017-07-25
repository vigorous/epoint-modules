package com.epoint.car.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_car_brand
 */
public class CarBrand extends BaseEntity {
    private Long id;

    /**
     * 品牌的首字母
     * 如：奥迪。则首字母就是A
     */
    private String word;

    /**
     * 品牌名
     */
    private String name;

    private String logo;

    private String remark;

    private String status;

    /**
     * 是否热门
     */
    private String isHot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }
}