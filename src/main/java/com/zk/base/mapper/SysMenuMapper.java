package com.zk.base.mapper;

import com.zk.base.model.SysMenu;

public interface SysMenuMapper {

    int deleteMenuByMenuId(Integer menuId);

    int addMenu(SysMenu record);

    int selectMenuList(SysMenu record);

    int updateMenu(SysMenu record);
}