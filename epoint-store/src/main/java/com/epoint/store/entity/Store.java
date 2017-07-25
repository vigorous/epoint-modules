package com.epoint.store.entity;

import com.epoint.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_store
 */
public class Store extends BaseEntity {
    private Long id;

    private String name;

    /**
     * 

     */
    private Date startTime;

    private Date endTime;

    private String linkman;

    private String tel;

    private String addr;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String remark;

    /**
     * : -1 连锁门店存放总店ID
     */
    private Long parentId;

    /**
     * 0 正常 1 2
     */
    private String status;

    private Long storeConfigId;

    private Integer pno;

    private Integer cno;

    private Integer dno;

    private String businessLicencePic;

    private String businessLicence;

    /**
     * 0是门店,1是平台供应商 2是门店自己加的供应商
     */
    private String type;

    /**
     * 供查询门店自己添加的供应商
     */
    private Long storeId;

    private Date closingDate;

    private Byte level;

    private String bankCardNumber;

    private Double area;

    private String regChannel;

    /**
     * 门店logo图片名称
     */
    private String imgStoreLogo;

    private String customerType;

    private String operator;

    private String spellShort;

    /**
     * 连锁门店编号
     */
    private String storeNo;

    /**
     * 隶属关系,门店类型
     */
    private String subjection;

    /**
     * 连锁隶属关系 比如：总部，直营，加盟，联盟等
     */
    private Integer chainType;

    /**
     * 总店添加/修改分店时操作人员id
     */
    private Long operatorId;

    /**
     * 管理员id,即linkman的id,对应erp_staff的id
     */
    private Long managerId;

    /**
     * 针对连锁总店，是否提供门店服务 0 不提供， 1 提供
     */
    private Short isProvideService;

    /**
     * 子门店数量
     */
    private Integer childStoreAmount;

    /**
     * 驿点商城会员ID
     */
    private Long epMallCustomerId;

    /**
     * 驿点商城店铺ID
     */
    private Long epMallStoreId;

    /**
     * 是否绑定驿点商城帐号。0:未绑定;1:已绑定;2:已解绑
     */
    private Integer isBindEpMall;

    /**
     * 绑定(驿点商城)日期
     */
    private Date bindTime;

    /**
     * 解除绑定(驿点商城)日期
     */
    private Date unbindTime;

    /**
     * 驿点MALL的我要采购菜单控制;0:无权使用该功能;1:有权使用该功能
     */
    private Short epMallBuyAuth;

    /**
     * 驿点MALL我的店铺菜单控制;0:无权使用该功能;1:有权使用该功能
     */
    private Short epMallSellAuth;

    /**
     * 内部管理系统注册时的手机号
     */
    private String mobile;

    /**
     * 关于我们
     */
    private String introduce;

    /**
     * 绑定门店名称
     */
    private String epMallStoreName;

    /**
     * 0:未导入;1:导入
     */
    private String isImport;

    /**
     * 父门店ID（根据父门店排序使用）
     */
    private Long pid;

    /**
     * 门店申请时初始化的手机号
     */
    private String initMobile;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStoreConfigId() {
        return storeConfigId;
    }

    public void setStoreConfigId(Long storeConfigId) {
        this.storeConfigId = storeConfigId;
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

    public String getBusinessLicencePic() {
        return businessLicencePic;
    }

    public void setBusinessLicencePic(String businessLicencePic) {
        this.businessLicencePic = businessLicencePic;
    }

    public String getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(String businessLicence) {
        this.businessLicence = businessLicence;
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

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getRegChannel() {
        return regChannel;
    }

    public void setRegChannel(String regChannel) {
        this.regChannel = regChannel;
    }

    public String getImgStoreLogo() {
        return imgStoreLogo;
    }

    public void setImgStoreLogo(String imgStoreLogo) {
        this.imgStoreLogo = imgStoreLogo;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSpellShort() {
        return spellShort;
    }

    public void setSpellShort(String spellShort) {
        this.spellShort = spellShort;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getSubjection() {
        return subjection;
    }

    public void setSubjection(String subjection) {
        this.subjection = subjection;
    }

    public Integer getChainType() {
        return chainType;
    }

    public void setChainType(Integer chainType) {
        this.chainType = chainType;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Short getIsProvideService() {
        return isProvideService;
    }

    public void setIsProvideService(Short isProvideService) {
        this.isProvideService = isProvideService;
    }

    public Integer getChildStoreAmount() {
        return childStoreAmount;
    }

    public void setChildStoreAmount(Integer childStoreAmount) {
        this.childStoreAmount = childStoreAmount;
    }

    public Long getEpMallCustomerId() {
        return epMallCustomerId;
    }

    public void setEpMallCustomerId(Long epMallCustomerId) {
        this.epMallCustomerId = epMallCustomerId;
    }

    public Long getEpMallStoreId() {
        return epMallStoreId;
    }

    public void setEpMallStoreId(Long epMallStoreId) {
        this.epMallStoreId = epMallStoreId;
    }

    public Integer getIsBindEpMall() {
        return isBindEpMall;
    }

    public void setIsBindEpMall(Integer isBindEpMall) {
        this.isBindEpMall = isBindEpMall;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getUnbindTime() {
        return unbindTime;
    }

    public void setUnbindTime(Date unbindTime) {
        this.unbindTime = unbindTime;
    }

    public Short getEpMallBuyAuth() {
        return epMallBuyAuth;
    }

    public void setEpMallBuyAuth(Short epMallBuyAuth) {
        this.epMallBuyAuth = epMallBuyAuth;
    }

    public Short getEpMallSellAuth() {
        return epMallSellAuth;
    }

    public void setEpMallSellAuth(Short epMallSellAuth) {
        this.epMallSellAuth = epMallSellAuth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getEpMallStoreName() {
        return epMallStoreName;
    }

    public void setEpMallStoreName(String epMallStoreName) {
        this.epMallStoreName = epMallStoreName;
    }

    public String getIsImport() {
        return isImport;
    }

    public void setIsImport(String isImport) {
        this.isImport = isImport;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getInitMobile() {
        return initMobile;
    }

    public void setInitMobile(String initMobile) {
        this.initMobile = initMobile;
    }
}