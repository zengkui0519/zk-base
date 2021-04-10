package com.zk.base.controller;

import com.zk.base.model.SysRole;
import com.zk.base.service.SysRoleService;
import com.zk.base.utils.ResultMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    /**
     * @description 分页查询所有角色
     * @param
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 4:52 下午
     */
    @PostMapping("/getAllSysRoleList")
    public ResultMessage getAllSysRoleList() {
        List<SysRole> result = sysRoleService.getAllSysRoleList();
        return ResultMessage.success(result);
    }

    /**
     * @description 添加角色
     * @param role
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 4:52 下午
     */
    @PostMapping("/saveSysRole")
    public ResultMessage saveSysRole(@RequestBody SysRole role) {
        String result = sysRoleService.saveSysRole(role);
        return ResultMessage.success(result);
    }

    /**
     * @description 获取角色详情
     * @param roleId
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 4:54 下午
     */
    @PostMapping("/getSysRoleInfo")
    public ResultMessage getSysRoleInfo(Integer roleId) {
        SysRole result = sysRoleService.getSysRoleInfo(roleId);
        return ResultMessage.success(result);
    }

    /**
     * @description 更新角色
     * @param role
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 4:53 下午
     */
    @PostMapping("/updateSysRole")
    public ResultMessage updateSysRole(@RequestBody SysRole role) {
        String result = sysRoleService.updateSysRole(role);
        return ResultMessage.success(result);
    }

    /**
     * @description 删除角色
     * @param roleId
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 4:53 下午
     */
    @PostMapping("/deleteSysRole")
    public ResultMessage deleteSysRole(Integer roleId) {
        String result = sysRoleService.deleteSysRole(roleId);
        return ResultMessage.success(result);
    }

}
