package com.zk.base.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zk.base.mapper.SysRoleMapper;
import com.zk.base.mapper.SysRoleMenuMapper;
import com.zk.base.model.SysRole;
import com.zk.base.model.SysRoleMenu;
import com.zk.base.model.SysUserRole;
import com.zk.base.model.vo.SysRoleVO;
import com.zk.base.service.SysRoleService;
import com.zk.base.utils.SysConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public String saveSysRole(SysRoleVO role) {
        Date now = new Date();
        role.setCreateTime(now);
        role.setUpdateTime(now);
        sysRoleMapper.addSysRole(role);
        saveRoleMenuList(role.getRoleId(), role.getMenuIdList());
        return SysConstants.Public.SUCCESS;
    }

    private void saveRoleMenuList(Integer roleId, List<Integer> menuIdList) {
        if (CollectionUtils.isEmpty(menuIdList)) {
            return;
        }
        sysRoleMenuMapper.deleteSysRoleMenuList(roleId);

        List<SysRoleMenu> roleMenuList = new ArrayList<>();
        for (Integer menuId : menuIdList) {
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuList.add(roleMenu);
        }
        sysRoleMenuMapper.addSysRoleMenuList(roleMenuList);
    }

    @Override
    public String updateSysRole(SysRoleVO role) {
        Date now = new Date();
        role.setUpdateTime(now);
        sysRoleMapper.updateSysRole(role);
        saveRoleMenuList(role.getRoleId(), role.getMenuIdList());
        return SysConstants.Public.SUCCESS;
    }

    @Override
    public String deleteSysRole(Integer roleId) {
        if (null == roleId) {
            return "角色ID不能为空";
        }

        sysRoleMenuMapper.deleteSysRoleMenuList(roleId);
        sysRoleMapper.deleteSysRoleByRoleId(roleId);
        return SysConstants.Public.SUCCESS;
    }

    @Override
    public Map<String, Object> getAllSysRoleList(int pageNum, int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<SysRole> dataList = sysRoleMapper.selectSysRoleList();

        Map<String, Object> result = new HashMap<>();
        result.put(SysConstants.Public.DATA_LIST, dataList);
        result.put(SysConstants.Public.TOTAL_COUNT, page.getTotal());
        return result;
    }

    @Override
    public SysRole getSysRoleInfo(Integer roleId) {
        return sysRoleMapper.selectSysRoleByRoleId(roleId);
    }

    @Override
    public boolean whetherTheRoleNameExist(Integer roleId, String roleName) {
        if (StringUtils.isBlank(roleName)) {
            // roleName为空返回true已存在
            return true;
        }

        Object object = sysRoleMapper.whetherTheRoleNameExist(roleId, roleName);
        if (null == object) {
            // 不存在返回false
            return false;
        }
        return true;
    }

}