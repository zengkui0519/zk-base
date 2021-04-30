package com.zk.base.model;

import lombok.Data;

import java.util.Date;

/**
 * @author ZengKui
 * @description 系统角色表
 * @date 2021/04/10 15:04
 */
@Data
public class SysRole {
    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 角色状态：0有效 1无效
     */
    private Integer roleStatus;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

}