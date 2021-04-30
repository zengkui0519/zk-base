package com.zk.base.mapper;

import com.zk.base.model.SysRoleMenu;

import java.util.List;

public interface SysRoleMenuMapper {

    void addSysRoleMenuList(List<SysRoleMenu> roleMenuList);

    void deleteSysRoleMenuList(Integer roleId);

    List<Integer> selectMenuIdList(Integer roleId);
}