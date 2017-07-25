package com.epoint.role.erp.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:erp_menu
 */
public class ErpMenu extends BaseEntity {
    private Integer id;

    /**
     * 菜单名称
     */
    private String menu;

    private String img;

    /**
     * 上一级菜单id
     */
    private Integer parentId;

    /**
     * 1
删除 0正常
     */
    private String status;

    private String oldMenuRole;

    private String oldUrlRole;

    private String menuType;

    /**
     * 层级 1代表1级
     */
    private Integer level;

    /**
     * 排序 序号
     */
    private Integer sort;

    /**
     * 样式
     */
    private String style;

    /**
     * 菜单url
     */
    private String url;

    private String menuRole;

    private String urlRole;

    private String oldUrl;

    /**
     * 区分页面还是按钮1:主要指1，2，3级菜单的页面;2:通过按钮跳转到页面;3:通过按钮执行动作,如：删除
     */
    private Long pageType;

    /**
     * 是否是公共资源
     */
    private Integer isPublic;

    /**
     * 0:所有门店都可以使用;1:链锁才可以使用的菜单(单不允许使用);
     */
    private Integer chainMenu;

    /**
     * 内部管理系统初始化权限用1：仓管，2：前台，3：财务
     */
    private Integer manageType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOldMenuRole() {
        return oldMenuRole;
    }

    public void setOldMenuRole(String oldMenuRole) {
        this.oldMenuRole = oldMenuRole;
    }

    public String getOldUrlRole() {
        return oldUrlRole;
    }

    public void setOldUrlRole(String oldUrlRole) {
        this.oldUrlRole = oldUrlRole;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuRole() {
        return menuRole;
    }

    public void setMenuRole(String menuRole) {
        this.menuRole = menuRole;
    }

    public String getUrlRole() {
        return urlRole;
    }

    public void setUrlRole(String urlRole) {
        this.urlRole = urlRole;
    }

    public String getOldUrl() {
        return oldUrl;
    }

    public void setOldUrl(String oldUrl) {
        this.oldUrl = oldUrl;
    }

    public Long getPageType() {
        return pageType;
    }

    public void setPageType(Long pageType) {
        this.pageType = pageType;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getChainMenu() {
        return chainMenu;
    }

    public void setChainMenu(Integer chainMenu) {
        this.chainMenu = chainMenu;
    }

    public Integer getManageType() {
        return manageType;
    }

    public void setManageType(Integer manageType) {
        this.manageType = manageType;
    }
}