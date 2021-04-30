package com.zk.base.controller;

import com.zk.base.model.SysRole;
import com.zk.base.model.vo.SysRoleVO;
import com.zk.base.service.SysRoleService;
import com.zk.base.utils.ResultMessage;
import com.zk.base.utils.SysConstants;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    /**
     * @param role
     * @return com.zk.base.utils.ResultMessage
     * @description 添加角色
     * @author zengkui
     * @date 2021/4/10 4:52 下午
     */
    @PostMapping("/saveSysRole")
    public ResultMessage saveSysRole(@RequestBody SysRoleVO role) {
        String result = sysRoleService.saveSysRole(role);
        if (SysConstants.Public.SUCCESS.equals(result)) {
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result);
    }

    /**
     * @param role
     * @return com.zk.base.utils.ResultMessage
     * @description 更新角色
     * @author zengkui
     * @date 2021/4/10 4:53 下午
     */
    @PostMapping("/updateSysRole")
    public ResultMessage updateSysRole(@RequestBody SysRoleVO role) {
        String result = sysRoleService.updateSysRole(role);
        if (SysConstants.Public.SUCCESS.equals(result)) {
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result);
    }

    /**
     * @param roleId
     * @return com.zk.base.utils.ResultMessage
     * @description 删除角色
     * @author zengkui
     * @date 2021/4/10 4:53 下午
     */
    @PostMapping("/deleteSysRole")
    public ResultMessage deleteSysRole(Integer roleId) {
        String result = sysRoleService.deleteSysRole(roleId);
        if (SysConstants.Public.SUCCESS.equals(result)) {
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result);
    }

    /**
     * @param
     * @return com.zk.base.utils.ResultMessage
     * @description 分页查询所有角色
     * @author zengkui
     * @date 2021/4/10 4:52 下午
     */
    @PostMapping("/getAllSysRoleList")
    public ResultMessage getAllSysRoleList(int pageNum, int pageSize) {
        Map<String, Object> result = sysRoleService.getAllSysRoleList(pageNum, pageSize);
        return ResultMessage.success(result);
    }

    /**
     * @param roleId
     * @return com.zk.base.utils.ResultMessage
     * @description 获取角色详情
     * @author zengkui
     * @date 2021/4/10 4:54 下午
     */
    @PostMapping("/getSysRoleInfo")
    public ResultMessage getSysRoleInfo(Integer roleId) {
        SysRole result = sysRoleService.getSysRoleInfo(roleId);
        return ResultMessage.success(result);
    }

    /**
     * @param roleName
     * @return com.zk.base.utils.ResultMessage
     * @description 是否roleName已存在
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @PostMapping("/whetherTheRoleNameExist")
    public ResultMessage whetherTheRoleNameExist(Integer roleId, String roleName) {
        boolean result = sysRoleService.whetherTheRoleNameExist(roleId, roleName);
        return ResultMessage.success(result);
    }

}
