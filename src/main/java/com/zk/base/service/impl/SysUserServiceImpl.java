package com.zk.base.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zk.base.mapper.SysUserMapper;
import com.zk.base.model.SysUser;
import com.zk.base.service.SysUserService;
import com.zk.base.utils.BusinessConstants;
import com.zk.base.utils.SysConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public String saveSysUser(SysUser user) {
        if (!validateSysUser(user)) {
            return "有必填项未填写，请确认！";
        }

        if (whetherTheSysUserExist(user)) {
            return "该用户已存在，请确认！";
        }

        Date now = new Date();
        user.setCreateTime(now);
        user.setCreateTime(now);
        user.setUpdateTime(now);
        user.setUserPassword(BusinessConstants.INITIAL_PASSWORD);
        user.setUserStatus(BusinessConstants.A);
        sysUserMapper.addSysUser(user);
        return SysConstants.Public.SUCCESS;
    }

    @Override
    public String updateSysUser(SysUser user) {
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
        if (whetherTheUserCodeExist(user.getUserCode())) {
            return true;
        }
        if (whetherTheUserEmailExist(user.getUserEmail())) {
            return true;
        }
        if (whetherTheUserTelExist(user.getUserTel())) {
            return true;
        }
        return false;
    }

    @Override
    public String deleteSysUser(Integer userId) {
        if (null == userId) {
            return "用户ID不能为空";
        }
        boolean result = sysUserMapper.deleteSysUserByUserId(userId);
        if (result) {
            return SysConstants.Public.SUCCESS;
        }
        return "删除失败";
    }

    @Override
    public Map<String, Object> getSysUserList(int pageNum, int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<SysUser> dataList = sysUserMapper.selectSysUserList();

        Map<String, Object> result = new HashMap<>();
        result.put(SysConstants.Public.DATA_LIST, dataList);
        result.put(SysConstants.Public.TOTAL_COUNT, page.getTotal());
        return result;
    }

    @Override
    public SysUser getSysUserInfo(Integer userId) {
        return sysUserMapper.selectSysUserByUserId(userId);
    }

    @Override
    public boolean whetherTheUserCodeExist(String userCode) {
        if (StringUtils.isBlank(userCode)) {
            // userCode为空返回true已存在
            return true;
        }

        Object object = sysUserMapper.whetherTheUserCodeExist(userCode);
        if (null == object) {
            // 不存在返回false
            return false;
        }
        return true;
    }

    @Override
    public boolean whetherTheUserTelExist(String userTel) {
        if (StringUtils.isBlank(userTel)) {
            // userTel为空返回true已存在
            return true;
        }

        Object object = sysUserMapper.whetherTheUserTelExist(userTel);
        if (null == object) {
            // 不存在返回false
            return false;
        }
        return true;
    }

    @Override
    public boolean whetherTheUserEmailExist(String userEmail) {
        if (StringUtils.isBlank(userEmail)) {
            // userEmail为空返回true已存在
            return true;
        }

        Object object = sysUserMapper.whetherTheUserEmailExist(userEmail);
        if (null == object) {
            // 不存在返回false
            return false;
        }
        return true;
    }

}