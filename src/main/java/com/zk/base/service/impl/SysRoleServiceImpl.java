package com.zk.base.service.impl;

import com.zk.base.mapper.SysUserMapper;
import com.zk.base.model.SysUser;
import com.zk.base.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public String saveSysUser(SysUser user) {
        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        sysUserMapper.addSysUser(user);
        return "SUCCESS";
    }

    @Override
    public String updateSysUser(SysUser user) {
        Date now = new Date();
        user.setUpdateTime(now);
        sysUserMapper.updateSysUser(user);
        return "SUCCESS";
    }

    @Override
    public String deleteSysUser(Integer userId) {
        sysUserMapper.deleteSysUserByUserId(userId);
        return "SUCCESS";
    }

    @Override
    public List<SysUser> getSysUserList() {
        return sysUserMapper.selectSysUserList();
    }

    @Override
    public SysUser getSysUserInfo(Integer userId) {
        return sysUserMapper.selectSysUserByUserId(userId);
    }

}