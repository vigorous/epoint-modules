package com.epoint.role.app.entity;

import com.epoint.entity.BaseEntity;

import java.util.List;

/**
 * 琛ㄥ悕:app_menu
 */
public class AppMenu extends BaseEntity {
    /**
     * 菜单id 自增
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 状态 0 正常 1 停用
     */
    private String status;

    private String level;

    private Integer parentId;

    private List<AppMenu> childs;

    private Integer sort;

    private String isHot;
    private String isImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AppMenu> getChilds() {
        return childs;
    }

    public void setChilds(List<AppMenu> childs) {
        this.childs = childs;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {

        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getIsImg() {
        return isImg;
    }

    public void setIsImg(String isImg) {
        this.isImg = isImg;
    }
}