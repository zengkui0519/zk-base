package com.zk.base.service;

import com.zk.base.model.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserService {

    String saveSysUser(SysUser user);

    String updateSysUser(SysUser user);

    String deleteSysUser(Integer userId);

    Map<String, Object> getSysUserList(int pageNum, int pageSize);

    SysUser getSysUserInfo(Integer userId);

    boolean whetherTheUserCodeExist(String userCode);

    boolean whetherTheUserTelExist(String userTel);

    boolean whetherTheUserEmailExist(String userEmail);
}