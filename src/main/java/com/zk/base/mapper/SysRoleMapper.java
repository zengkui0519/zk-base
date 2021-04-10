package com.zk.base.mapper;

import com.zk.base.model.SysRole;

public interface SysRoleMapper {

    int deleteRoleByRoleId(Integer roleId);

    int addRole(SysRole record);

    int selectRoleList(SysRole record);

    int updateRole(SysRole record);
}