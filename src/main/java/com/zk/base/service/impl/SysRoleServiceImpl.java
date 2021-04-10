package com.zk.base.service.impl;

import com.zk.base.mapper.SysRoleMapper;
import com.zk.base.model.SysRole;
import com.zk.base.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public String saveSysRole(SysRole role) {
        Date now = new Date();
        role.setCreateTime(now);
        role.setUpdateTime(now);
        sysRoleMapper.addSysRole(role);
        return "SUCCESS";
    }

    @Override
    public String updateSysRole(SysRole role) {
        Date now = new Date();
        role.setUpdateTime(now);
        sysRoleMapper.updateSysRole(role);
        return "SUCCESS";
    }

    @Override
    public String deleteSysRole(Integer roleId) {
        sysRoleMapper.deleteSysRoleByRoleId(roleId);
        return "SUCCESS";
    }

    @Override
    public List<SysRole> getAllSysRoleList() {
        return sysRoleMapper.selectSysRoleList();
    }

    @Override
    public SysRole getSysRoleInfo(Integer roleId) {
        return sysRoleMapper.selectSysRoleByRoleId(roleId);
    }

}