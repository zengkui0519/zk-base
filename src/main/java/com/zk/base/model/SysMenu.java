package com.zk.base.model;

import lombok.Data;

import java.util.Date;

/**
 * @author ZengKui
 * @description 系统菜单表
 * @date 2021/04/10 15:05
 */
@Data
public class SysMenu {
    /**
     * 菜单ID
     */
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单地址
     */
    private String menuUrl;

    /**
     * 父菜单ID
     */
    private String parentId;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 菜单状态：0有效 1无效
     */
    private Integer menuStatus;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

}