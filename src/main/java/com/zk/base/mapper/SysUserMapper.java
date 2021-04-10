package com.zk.base.mapper;

import com.zk.base.model.SysUser;

import java.util.List;

public interface SysUserMapper {

    boolean deleteSysUserByUserId(Integer userId);

    int addSysUser(SysUser record);

    Object whetherTheUserCodeExist(String userCode);

    Object whetherTheUserTelExist(String userTel);

    Object whetherTheUserEmailExist(String userEmail);

    SysUser selectSysUserByUserId(Integer userId);

    int updateSysUser(SysUser record);

    List<SysUser> selectSysUserList();
}