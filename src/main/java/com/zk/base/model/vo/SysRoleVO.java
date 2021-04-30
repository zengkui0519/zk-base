package com.zk.base.model.vo;

import com.zk.base.model.SysRole;
import lombok.Data;

import java.util.List;

/**
 * @author ZengKui
 * @description 系统角色表
 * @date 2021/04/10 15:04
 */
@Data
public class SysRoleVO extends SysRole {

    List<Integer> menuIdList;

}