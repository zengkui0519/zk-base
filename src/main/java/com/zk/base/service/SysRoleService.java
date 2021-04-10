package com.zk.base.service;

import com.zk.base.model.SysRole;

import java.util.List;

public interface SysRoleService {

    String saveSysRole(SysRole role);

    String updateSysRole(SysRole role);

    String deleteSysRole(Integer roleId);

    List<SysRole> getAllSysRoleList();

    SysRole getSysRoleInfo(Integer roleId);
}