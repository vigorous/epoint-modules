package com.epoint.role.boss.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:boss_menu
 */
public class BossMenu extends BaseEntity {
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
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}