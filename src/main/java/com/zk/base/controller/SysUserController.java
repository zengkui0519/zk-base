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

    @PostMapping("/saveSysUser")
    public ResultMessage saveSysUser(@RequestBody SysUser user) {
        String result = sysUserService.saveSysUser(user);
        return ResultMessage.success(result);
    }

    @PostMapping("/updateSysUser")
    public ResultMessage updateSysUser(@RequestBody SysUser user) {
        String result = sysUserService.updateSysUser(user);
        return ResultMessage.success(result);
    }

    @PostMapping("/deleteSysUser")
    public ResultMessage deleteSysUser(Integer userId) {
        String result = sysUserService.deleteSysUser(userId);
        return ResultMessage.success(result);
    }

    @PostMapping("/getSysUserList")
    public ResultMessage getSysUserList() {
        List<SysUser> result = sysUserService.getSysUserList();
        return ResultMessage.success(result);
    }

    @PostMapping("/getSysUserInfo")
    public ResultMessage getSysUserInfo(Integer userId) {
        SysUser result = sysUserService.getSysUserInfo(userId);
        return ResultMessage.success(result);
    }

}
