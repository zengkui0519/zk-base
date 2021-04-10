package com.zk.base.controller;

import com.zk.base.model.SysUser;
import com.zk.base.service.SysUserService;
import com.zk.base.utils.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * @description 添加用户
     * @param user
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:19 下午
     */
    @PostMapping("/saveSysUser")
    public ResultMessage saveSysUser(@RequestBody SysUser user) {
        String result = sysUserService.saveSysUser(user);
        return ResultMessage.success(result);
    }

    /**
     * @description 更新用户
     * @param user
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:20 下午
     */
    @PostMapping("/updateSysUser")
    public ResultMessage updateSysUser(@RequestBody SysUser user) {
        String result = sysUserService.updateSysUser(user);
        return ResultMessage.success(result);
    }

    /**
     * @description 删除用户
     * @param userId
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:20 下午
     */
    @PostMapping("/deleteSysUser")
    public ResultMessage deleteSysUser(Integer userId) {
        String result = sysUserService.deleteSysUser(userId);
        return ResultMessage.success(result);
    }

    /**
     * @description 分页获取用户列表
     * @param
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:20 下午
     */
    @PostMapping("/getSysUserList")
    public ResultMessage getSysUserList() {
        List<SysUser> result = sysUserService.getSysUserList();
        return ResultMessage.success(result);
    }

    /**
     * @description 获取用户详情
     * @param userId
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @PostMapping("/getSysUserInfo")
    public ResultMessage getSysUserInfo(Integer userId) {
        SysUser result = sysUserService.getSysUserInfo(userId);
        return ResultMessage.success(result);
    }

}
