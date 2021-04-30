package com.zk.base.mapper;

import com.zk.base.model.SysUser;
import com.zk.base.model.request.UserReqParam;
import com.zk.base.model.vo.SysUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {

    boolean deleteSysUserByUserId(Integer userId);

    int addSysUser(SysUser record);

    Object whetherTheUserCodeExist(@Param("userId") Integer userId, @Param("userCode") String userCode);

    Object whetherTheUserTelExist(@Param("userId") Integer userId, @Param("userTel") String userTel);

    Object whetherTheUserEmailExist(@Param("userId") Integer userId, @Param("userEmail") String userEmail);

    SysUserVO selectSysUserByUserId(Integer userId);

    int updateSysUser(SysUser record);

    List<SysUser> selectSysUserList(UserReqParam reqParam);

}