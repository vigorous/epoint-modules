package com.epoint.car.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_car_model
 */
public class CarModel extends BaseEntity {
    private Long id;

    private String name;

    private Long carBrandId;

    private Long carSeriesId;

    private String guidePrice;

    private Double price;

    /**
     * 力洋ID
     */
    private String levelid;

    /**
     * 年款
     */
    private Short modelYear;

    /**
     * 排放标准
     */
    private String emission;

    /**
     * 上市年份
     */
    private Short tty;

    /**
     * 上市月份
     */
    private Short ttm;

    /**
     * 停产年份
     */
    private Short tsy;

    /**
     * 是否进口
     * ‘0’:国产
     * ‘1’:进口
     * ‘2’:合资
     * ‘3’:其它
     */
    private String importType;

    private String remark;

    private String status;

    private String attribute;

    /**
     * 千米车型ID
     */
    private Long kstoreId;

    /**
     * 根据品牌，车系，车型，年份查询，会对应多条记录；设置其中一条记录标志位，前端选择车型时，只查询该记录
     */
    private Short uniqueIndexed;

    /**
     * 气缸描述
     */
    private String cylinder;

    /**
     * 引擎位置 1 前置 2 中置 3 后置
     */
    private Short enginerPlace;

    /**
     * 驱动方式 1 前轮驱动 2 后轮驱动 3 四轮驱动 4 全时驱动 5 分时驱动 6 适时驱动
     */
    private Short driverType;

    /**
     * 燃油标号
     */
    private Short oilGrade;

    /**
     * 前制动器类型 1 盘式 2 鼓式 3 通风盘式 4 陶瓷通风盘式
     */
    private Short frontBrakeType;

    /**
     * 后制动器类型 1 盘式 2 鼓式 3 通风盘式 4 陶瓷通风盘式
     */
    private Short rearBrakeType;

    /**
     * 变速器描述
     */
    private String gearbox;

    /**
     * 助力类型
     */
    private String powerSteer;

    /**
     * 前轮胎规格
     */
    private String frontTyreSpec;

    /**
     * 后轮胎规格
     */
    private String rearTyreSpec;

    /**
     * 前轮毂规格
     */
    private String frontHubSpec;

    /**
     * 后轮毂规格
     */
    private String rearHubSpec;

    /**
     * 生产商
     */
    private String producer;

    /**
     * 进气形式
     */
    private String intakeForm;

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

    public Long getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(Long carBrandId) {
        this.carBrandId = carBrandId;
    }

    public Long getCarSeriesId() {
        return carSeriesId;
    }

    public void setCarSeriesId(Long carSeriesId) {
        this.carSeriesId = carSeriesId;
    }

    public String getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(String guidePrice) {
        this.guidePrice = guidePrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLevelid() {
        return levelid;
    }

    public void setLevelid(String levelid) {
        this.levelid = levelid;
    }

    public Short getModelYear() {
        return modelYear;
    }

    public void setModelYear(Short modelYear) {
        this.modelYear = modelYear;
    }

    public String getEmission() {
        return emission;
    }

    public void setEmission(String emission) {
        this.emission = emission;
    }

    public Short getTty() {
        return tty;
    }

    public void setTty(Short tty) {
        this.tty = tty;
    }

    public Short getTtm() {
        return ttm;
    }

    public void setTtm(Short ttm) {
        this.ttm = ttm;
    }

    public Short getTsy() {
        return tsy;
    }

    public void setTsy(Short tsy) {
        this.tsy = tsy;
    }

    public String getImportType() {
        return importType;
    }

    public void setImportType(String importType) {
        this.importType = importType;
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

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Long getKstoreId() {
        return kstoreId;
    }

    public void setKstoreId(Long kstoreId) {
        this.kstoreId = kstoreId;
    }

    public Short getUniqueIndexed() {
        return uniqueIndexed;
    }

    public void setUniqueIndexed(Short uniqueIndexed) {
        this.uniqueIndexed = uniqueIndexed;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public Short getEnginerPlace() {
        return enginerPlace;
    }

    public void setEnginerPlace(Short enginerPlace) {
        this.enginerPlace = enginerPlace;
    }

    public Short getDriverType() {
        return driverType;
    }

    public void setDriverType(Short driverType) {
        this.driverType = driverType;
    }

    public Short getOilGrade() {
        return oilGrade;
    }

    public void setOilGrade(Short oilGrade) {
        this.oilGrade = oilGrade;
    }

    public Short getFrontBrakeType() {
        return frontBrakeType;
    }

    public void setFrontBrakeType(Short frontBrakeType) {
        this.frontBrakeType = frontBrakeType;
    }

    public Short getRearBrakeType() {
        return rearBrakeType;
    }

    public void setRearBrakeType(Short rearBrakeType) {
        this.rearBrakeType = rearBrakeType;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getPowerSteer() {
        return powerSteer;
    }

    public void setPowerSteer(String powerSteer) {
        this.powerSteer = powerSteer;
    }

    public String getFrontTyreSpec() {
        return frontTyreSpec;
    }

    public void setFrontTyreSpec(String frontTyreSpec) {
        this.frontTyreSpec = frontTyreSpec;
    }

    public String getRearTyreSpec() {
        return rearTyreSpec;
    }

    public void setRearTyreSpec(String rearTyreSpec) {
        this.rearTyreSpec = rearTyreSpec;
    }

    public String getFrontHubSpec() {
        return frontHubSpec;
    }

    public void setFrontHubSpec(String frontHubSpec) {
        this.frontHubSpec = frontHubSpec;
    }

    public String getRearHubSpec() {
        return rearHubSpec;
    }

    public void setRearHubSpec(String rearHubSpec) {
        this.rearHubSpec = rearHubSpec;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getIntakeForm() {
        return intakeForm;
    }

    public void setIntakeForm(String intakeForm) {
        this.intakeForm = intakeForm;
    }
}