package com.zk.base.model;

import lombok.Data;

/**
 * @author ZengKui
 * @description 用户角色表
 * @date 2021/04/10 15:04
 */
@Data
public class SysUserRole {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

}