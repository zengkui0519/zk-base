package com.zk.base.mapper;

import com.zk.base.model.SysRole;

import java.util.List;

public interface SysRoleMapper {

    int deleteSysRoleByRoleId(Integer roleId);

    int addSysRole(SysRole record);

    List<SysRole> selectSysRoleList();

    int updateSysRole(SysRole record);

    SysRole selectSysRoleByRoleId(Integer roleId);
}