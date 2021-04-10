package com.zk.base.mapper;

import com.zk.base.model.SysUser;

import java.util.List;

public interface SysUserMapper {

    int deleteSysUserByUserId(Integer userId);

    int addSysUser(SysUser record);

    SysUser selectSysUserByUserId(Integer userId);

    int updateSysUser(SysUser record);

    List<SysUser> selectSysUserList();
}