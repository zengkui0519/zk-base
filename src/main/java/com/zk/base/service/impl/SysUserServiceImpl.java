package com.zk.base.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zk.base.mapper.SysUserMapper;
import com.zk.base.mapper.SysUserRoleMapper;
import com.zk.base.model.SysUser;
import com.zk.base.model.SysUserRole;
import com.zk.base.model.request.UserReqParam;
import com.zk.base.model.vo.SysUserVO;
import com.zk.base.service.SysUserService;
import com.zk.base.utils.BusinessConstants;
import com.zk.base.utils.SysConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public String saveSysUser(SysUserVO user) {
        if (!validateSysUser(user)) {
            return "有必填项未填写，请确认！";
        }

        if (whetherTheSysUserExist(user)) {
            return "该用户已存在，请确认！";
        }

        Date now = new Date();
        user.setCreateUser("admin");
        user.setCreateTime(now);
        user.setUpdateUser("admin");
        user.setUpdateTime(now);
        user.setUserPassword(BusinessConstants.INITIAL_PASSWORD);
        user.setUserStatus(BusinessConstants.A);
        sysUserMapper.addSysUser(user);
        saveUserRoleList(user.getUserId(), user.getRoleIdList());
        return SysConstants.Public.SUCCESS;
    }

    private void saveUserRoleList(Integer userId, List<Integer> roleIdList) {
        if (CollectionUtils.isEmpty(roleIdList)) {
            return;
        }
        sysUserRoleMapper.deleteSysUserRoleList(userId);

        List<SysUserRole> userRoleList = new ArrayList<>();
        for (Integer roleId : roleIdList) {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleList.add(userRole);
        }
        sysUserRoleMapper.addSysUserRoleList(userRoleList);
    }

    @Override
    public String updateSysUser(SysUserVO user) {
        if (!validateSysUser(user) || null == user.getUserId()) {
            return "有必填项未填写，请确认！";
        }

        if (whetherTheSysUserExist(user)) {
            return "该用户已存在，请确认！";
        }

        Date now = new Date();
        user.setUpdateTime(now);
        user.setUserPassword(BusinessConstants.INITIAL_PASSWORD);
        user.setUserStatus(BusinessConstants.A);
        sysUserMapper.updateSysUser(user);
        saveUserRoleList(user.getUserId(), user.getRoleIdList());
        return SysConstants.Public.SUCCESS;
    }

    private boolean validateSysUser(SysUser user) {
        // 验证用户编码、用户姓名、用户手机号等必填项是否填写
        if (StringUtils.isBlank(user.getUserCode())
                || StringUtils.isBlank(user.getUserName())
                || StringUtils.isBlank(user.getUserEmail())
                || StringUtils.isBlank(user.getUserTel())) {
            return false;
        }
        return true;
    }

    private boolean whetherTheSysUserExist(SysUser user) {
        if (whetherTheUserCodeExist(user.getUserId(), user.getUserCode())) {
            return true;
        }
        if (whetherTheUserEmailExist(user.getUserId(), user.getUserEmail())) {
            return true;
        }
        if (whetherTheUserTelExist(user.getUserId(), user.getUserTel())) {
            return true;
        }
        return false;
    }

    @Override
    public String deleteSysUser(Integer userId) {
        if (null == userId) {
            return "用户ID不能为空";
        }
        sysUserRoleMapper.deleteSysUserRoleList(userId);
        sysUserMapper.deleteSysUserByUserId(userId);
        return SysConstants.Public.SUCCESS;
    }

    @Override
    public Map<String, Object> getSysUserList(UserReqParam reqParam) {
        Page<Object> page = PageHelper.startPage(reqParam.getPageNum(), reqParam.getPageSize());
        List<SysUser> dataList = sysUserMapper.selectSysUserList(reqParam);

        Map<String, Object> result = new HashMap<>();
        result.put(SysConstants.Public.DATA_LIST, dataList);
        result.put(SysConstants.Public.TOTAL_COUNT, page.getTotal());
        return result;
    }

    @Override
    public SysUserVO getSysUserInfo(Integer userId) {
        return sysUserMapper.selectSysUserByUserId(userId);
    }

    @Override
    public boolean whetherTheUserCodeExist(Integer userId, String userCode) {
        if (StringUtils.isBlank(userCode)) {
            // userCode为空返回true已存在
            return true;
        }

        Object object = sysUserMapper.whetherTheUserCodeExist(userId, userCode);
        if (null == object) {
            // 不存在返回false
            return false;
        }
        return true;
    }

    @Override
    public boolean whetherTheUserTelExist(Integer userId, String userTel) {
        if (StringUtils.isBlank(userTel)) {
            // userTel为空返回true已存在
            return true;
        }

        Object object = sysUserMapper.whetherTheUserTelExist(userId, userTel);
        if (null == object) {
            // 不存在返回false
            return false;
        }
        return true;
    }

    @Override
    public boolean whetherTheUserEmailExist(Integer userId, String userEmail) {
        if (StringUtils.isBlank(userEmail)) {
            // userEmail为空返回true已存在
            return true;
        }

        Object object = sysUserMapper.whetherTheUserEmailExist(userId, userEmail);
        if (null == object) {
            // 不存在返回false
            return false;
        }
        return true;
    }

}