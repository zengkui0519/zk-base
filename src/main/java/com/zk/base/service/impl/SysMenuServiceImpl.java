package com.zk.base.service.impl;

import com.zk.base.mapper.SysMenuMapper;
import com.zk.base.model.SysMenu;
import com.zk.base.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public String saveSysMenu(SysMenu menu) {
        Date now = new Date();
        menu.setCreateTime(now);
        menu.setUpdateTime(now);
        sysMenuMapper.addSysMenu(menu);
        return "SUCCESS";
    }

    @Override
    public String updateSysMenu(SysMenu menu) {
        Date now = new Date();
        menu.setUpdateTime(now);
        sysMenuMapper.updateSysMenu(menu);
        return "SUCCESS";
    }

    @Override
    public String deleteSysMenu(Integer menuId) {
        sysMenuMapper.deleteSysMenuByMenuId(menuId);
        return "SUCCESS";
    }

    @Override
    public List<SysMenu> getAllSysMenuList() {
        return sysMenuMapper.selectSysMenuList();
    }

    @Override
    public SysMenu getSysMenuInfo(Integer menuId) {
        return sysMenuMapper.selectSysMenuByMenuId(menuId);
    }

    @Override
    public List<SysMenu> getSysMenuListByPId() {
        return null;
    }

}