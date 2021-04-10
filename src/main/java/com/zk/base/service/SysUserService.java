package com.zk.base.service;

import com.zk.base.model.SysUser;

import java.util.List;

public interface SysUserService {

    String saveSysUser(SysUser user);

    String updateSysUser(SysUser user);

    String deleteSysUser(Integer userId);

    List<SysUser> getSysUserList();

    SysUser getSysUserInfo(Integer userId);

    boolean whetherTheUserCodeExist(String userCode);

    boolean whetherTheUserTelExist(String userTel);

    boolean whetherTheUserEmailExist(String userEmail);
}