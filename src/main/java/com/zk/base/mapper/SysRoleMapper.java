package com.zk.base.mapper;

import com.zk.base.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {

    int deleteSysRoleByRoleId(Integer roleId);

    int addSysRole(SysRole record);

    List<SysRole> selectSysRoleList();

    int updateSysRole(SysRole record);

    SysRole selectSysRoleByRoleId(Integer roleId);

    Object whetherTheRoleNameExist(@Param("roleId") Integer roleId, @Param("roleName") String roleName);
}