package com.zk.base.service;

import com.zk.base.model.request.UserReqParam;
import com.zk.base.model.vo.SysUserVO;

import java.util.Map;

public interface SysUserService {

    String saveSysUser(SysUserVO user);

    String updateSysUser(SysUserVO user);

    String deleteSysUser(Integer userId);

    Map<String, Object> getSysUserList(UserReqParam reqParam);

    SysUserVO getSysUserInfo(Integer userId);

    boolean whetherTheUserCodeExist(Integer userId, String userCode);

    boolean whetherTheUserTelExist(Integer userId, String userTel);

    boolean whetherTheUserEmailExist(Integer userId, String userEmail);
}