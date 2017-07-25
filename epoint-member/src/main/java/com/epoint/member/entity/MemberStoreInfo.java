package com.epoint.member.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_member_store_info
 */
public class MemberStoreInfo extends BaseEntity {
    /**
     * 门店下所有查询涉及到的 erp_member_id 都指向本字段
     */
    private Long id;

    private Long storeId;

    /**
     * 平台用户编号，指向 erp_member.id
     */
    private Long memberId;

    /**
     * 门店客户累计积分
     */
    private Double point;

    /**
     * 0
     *  1(0或null为非会员，1为会员)
     */
    private String hasCard;

    /**
     * 0 正常 1 删除
     */
    private String status;

    /**
     * 客户来源
     */
    private String customerFrom;

    /**
     * 客户顾问id（即员工id）
     */
    private Long memberManagerId;

    /**
     * 1 iPhone-员工端 2 Android-员工端 3 ERP
     */
    private String regChannel;

    /**
     * 会员级别
     */
    private Long memberLevelId;

    /**
     * 会员类型  
     * 0 个人
     * 1 集团
     */
    private Integer memberType;

    /**
     * 会员名称
     */
    private String name;

    /**
     * 会员简称、昵称
     */
    private String nick;

    /**
     * 0：女
     * 1：男
     */
    private String sex;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 地址
     */
    private String addr;

    private String uuid;

    private Date birth;

    /**
     * 驾驶证类型
     */
    private String driveType;

    /**
     * 回访日期
     */
    private Date reviewdate;

    private String email;

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 公司
     */
    private String company;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 驾驶证号
     */
    private String drivingLicenseNo;

    private String weixin;

    /**
     * 省
     */
    private Integer pno;

    /**
     * 市
     */
    private Integer cno;

    /**
     * 区
     */
    private Integer dno;

    /**
     * 座机 国定电话
     */
    private String landlinePhone;

    /**
     * 客户编号　导入时使用
     */
    private String memberNo;

    /**
     * 默认车辆
     */
    private Long primaryCar;

    /**
     * 备注
     */
    private String remark;

    /**
     * 门店累计消费(来源订单的总价)
     */
    private Double sumConsume;

    /**
     * 门店累计消费现金
     */
    private Double sumCash;

    /**
     * 客户购买会员卡时间
     */
    private Date buyCardTime;

    /**
     * 登录时间
     */
    private Date loginTime;

    private String carNo;

    /**
     * 保险日期
     */
    private Date insuranceDate;

    /**
     * 融云token
     */
    private String token;

    private String header;

    private String imLabel;

    private Integer randomCode;

    private Double oil;

    /**
     * 二维码url(自动洗车使用)
     */
    private String qrCode;

    /**
     * 密码 md5
     */
    private String password;

    /**
     * 平台积分总计
     */
    private Double platformPoint;

    /**
     * 1:通过APP注册
     * 2:通过门店的ERP注册
     */
    private String selfRegister;

    /**
     * 车架号
     */
    private String vehicleId;

    /**
     * 公里数
     */
    private Double kilometers;

    /**
     * 车牌型号
     */
    private Long carModelId;

    /**
     * 车辆牌品
     */
    private Long carBrandId;

    /**
     * 车系
     */
    private Long carSeriesId;

    /**
     * 父门店ID
     */
    private Long parentStoreId;

    /**
     * 微信公众号appid
     */
    private String wxAppId;

    /**
     * 微信openid
     */
    private String openId;

    /**
     * 微信union open id
     */
    private String unionOpenId;

    /**
     * 对应商城用户编号
     */
    private Long mallUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getHasCard() {
        return hasCard;
    }

    public void setHasCard(String hasCard) {
        this.hasCard = hasCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerFrom() {
        return customerFrom;
    }

    public void setCustomerFrom(String customerFrom) {
        this.customerFrom = customerFrom;
    }

    public Long getMemberManagerId() {
        return memberManagerId;
    }

    public void setMemberManagerId(Long memberManagerId) {
        this.memberManagerId = memberManagerId;
    }

    public String getRegChannel() {
        return regChannel;
    }

    public void setRegChannel(String regChannel) {
        this.regChannel = regChannel;
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public Date getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(Date reviewdate) {
        this.reviewdate = reviewdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public String getLandlinePhone() {
        return landlinePhone;
    }

    public void setLandlinePhone(String landlinePhone) {
        this.landlinePhone = landlinePhone;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public Long getPrimaryCar() {
        return primaryCar;
    }

    public void setPrimaryCar(Long primaryCar) {
        this.primaryCar = primaryCar;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getSumConsume() {
        return sumConsume;
    }

    public void setSumConsume(Double sumConsume) {
        this.sumConsume = sumConsume;
    }

    public Double getSumCash() {
        return sumCash;
    }

    public void setSumCash(Double sumCash) {
        this.sumCash = sumCash;
    }

    public Date getBuyCardTime() {
        return buyCardTime;
    }

    public void setBuyCardTime(Date buyCardTime) {
        this.buyCardTime = buyCardTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getImLabel() {
        return imLabel;
    }

    public void setImLabel(String imLabel) {
        this.imLabel = imLabel;
    }

    public Integer getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(Integer randomCode) {
        this.randomCode = randomCode;
    }

    public Double getOil() {
        return oil;
    }

    public void setOil(Double oil) {
        this.oil = oil;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getPlatformPoint() {
        return platformPoint;
    }

    public void setPlatformPoint(Double platformPoint) {
        this.platformPoint = platformPoint;
    }

    public String getSelfRegister() {
        return selfRegister;
    }

    public void setSelfRegister(String selfRegister) {
        this.selfRegister = selfRegister;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public Long getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Long carModelId) {
        this.carModelId = carModelId;
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

    public Long getParentStoreId() {
        return parentStoreId;
    }

    public void setParentStoreId(Long parentStoreId) {
        this.parentStoreId = parentStoreId;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionOpenId() {
        return unionOpenId;
    }

    public void setUnionOpenId(String unionOpenId) {
        this.unionOpenId = unionOpenId;
    }

    public Long getMallUserId() {
        return mallUserId;
    }

    public void setMallUserId(Long mallUserId) {
        this.mallUserId = mallUserId;
    }
}