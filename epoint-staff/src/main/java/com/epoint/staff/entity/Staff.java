package com.epoint.staff.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_staff
 */
public class Staff extends BaseEntity {
    private Long id;

    /**
     * 聊天使用
     */
    private String uuid;

    /**
     * 融云token
     */
    private String token;

    /**
     * 登录的用户名
     * 如果未填写用户名，则随机生成一个。如：技师就直接通过手机号注册，通过手机号码登录。
     * 
     * 门店申请的时候，则必须填写用户名，用于登录
     */
    private String userName;

    /**
     * 手机号码。登录使用
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 名称首字母
     */
    private String nameShort;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 地址
     */
    private String addr;

    /**
     * 废弃
     */
    private Long erpStaffStoreId;

    /**
     * 0：是普通的技师账号；
     * 1：是门店账号
     * 2：是供应商的账号
     */
    private String type;

    private String email;

    /**
     * 个性签名
     */
    private String imLabel;

    private String deviceId;

    private String osType;

    private String sex;

    /**
     * 头像图片
     */
    private String header;

    private Date birth;

    /**
     * 试用门店名称
     */
    private String storeName;

    /**
     * 省
     */
    private String pno;

    /**
     * 市
     */
    private String cno;

    /**
     * 区/县
     */
    private String dno;

    private Date closingDate;

    /**
     * 是否为申请试用类型,0为false,1为true
     */
    private String isprobation;

    /**
     * 省
     */
    private String pname;

    /**
     * 市
     */
    private String cname;

    /**
     * 区/县
     */
    private String dname;

    /**
     * 注册来源。0:pc;1:mobile
     */
    private Integer registerFrom;

    /**
     * 0:门店ERP,1:员工APP,2:管理APP
     */
    private String clientAccess;

    /**
     * 岗位Id
     */
    private Long erpStationId;

    /**
     * 总店员工允许访问的下属门店编号，以 , 号分割
     */
    private String allowStoreId;

    /**
     * 关联门店IDs
     */
    private String erpStaffStoreIds;

    private Long parentStaffStoreId;

    /**
     * 阅读过的版本信息id
     */
    private Short readVersionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Long getErpStaffStoreId() {
        return erpStaffStoreId;
    }

    public void setErpStaffStoreId(Long erpStaffStoreId) {
        this.erpStaffStoreId = erpStaffStoreId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImLabel() {
        return imLabel;
    }

    public void setImLabel(String imLabel) {
        this.imLabel = imLabel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getIsprobation() {
        return isprobation;
    }

    public void setIsprobation(String isprobation) {
        this.isprobation = isprobation;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getRegisterFrom() {
        return registerFrom;
    }

    public void setRegisterFrom(Integer registerFrom) {
        this.registerFrom = registerFrom;
    }

    public String getClientAccess() {
        return clientAccess;
    }

    public void setClientAccess(String clientAccess) {
        this.clientAccess = clientAccess;
    }

    public Long getErpStationId() {
        return erpStationId;
    }

    public void setErpStationId(Long erpStationId) {
        this.erpStationId = erpStationId;
    }

    public String getAllowStoreId() {
        return allowStoreId;
    }

    public void setAllowStoreId(String allowStoreId) {
        this.allowStoreId = allowStoreId;
    }

    public String getErpStaffStoreIds() {
        return erpStaffStoreIds;
    }

    public void setErpStaffStoreIds(String erpStaffStoreIds) {
        this.erpStaffStoreIds = erpStaffStoreIds;
    }

    public Long getParentStaffStoreId() {
        return parentStaffStoreId;
    }

    public void setParentStaffStoreId(Long parentStaffStoreId) {
        this.parentStaffStoreId = parentStaffStoreId;
    }

    public Short getReadVersionId() {
        return readVersionId;
    }

    public void setReadVersionId(Short readVersionId) {
        this.readVersionId = readVersionId;
    }
}