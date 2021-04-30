package com.zk.base.service;

import com.zk.base.model.SysRole;
import com.zk.base.model.vo.SysRoleVO;

import java.util.Map;

public interface SysRoleService {

    String saveSysRole(SysRoleVO role);

    String updateSysRole(SysRoleVO role);

    String deleteSysRole(Integer roleId);

    Map<String, Object> getAllSysRoleList(int pageNum, int pageSize);

    SysRole getSysRoleInfo(Integer roleId);

    boolean whetherTheRoleNameExist(Integer roleId, String roleName);

}