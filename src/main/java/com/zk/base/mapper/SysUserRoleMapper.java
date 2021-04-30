package com.zk.base.mapper;

import com.zk.base.model.SysUserRole;

import java.util.List;

public interface SysUserRoleMapper {

    void addSysUserRoleList(List<SysUserRole> userRoleList);

    void deleteSysUserRoleList(Integer userId);

    List<Integer> selectRoleIdList(Integer userId);
}