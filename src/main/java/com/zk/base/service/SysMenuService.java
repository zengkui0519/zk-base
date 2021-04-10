package com.zk.base.service;

import com.zk.base.model.SysMenu;

import java.util.List;

public interface SysMenuService {

    String saveSysMenu(SysMenu menu);

    String updateSysMenu(SysMenu menu);

    String deleteSysMenu(Integer menuId);

    List<SysMenu> getAllSysMenuList();

    SysMenu getSysMenuInfo(Integer menuId);

    List<SysMenu> getSysMenuListByPId();
}