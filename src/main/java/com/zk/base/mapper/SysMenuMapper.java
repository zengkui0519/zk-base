package com.zk.base.mapper;

import com.zk.base.model.SysMenu;

import java.util.List;

public interface SysMenuMapper {

    int deleteSysMenuByMenuId(Integer menuId);

    int addSysMenu(SysMenu record);

    List<SysMenu> selectSysMenuList();

    int updateSysMenu(SysMenu record);

    SysMenu selectSysMenuByMenuId(Integer menuId);
}