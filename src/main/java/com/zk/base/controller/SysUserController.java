package com.zk.base.controller;

import com.zk.base.model.SysUser;
import com.zk.base.service.SysUserService;
import com.zk.base.utils.ResultMessage;
import com.zk.base.utils.SysConstants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
        if (SysConstants.Public.SUCCESS.equals(result)) {
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result);
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
        if (SysConstants.Public.SUCCESS.equals(result)) {
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result);
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
        if (SysConstants.Public.SUCCESS.equals(result)) {
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result);
    }

    /**
     * @description 分页获取用户列表
     * @param
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:20 下午
     */
    @GetMapping("/getSysUserList")
    public ResultMessage getSysUserList(int pageNum, int pageSize) {
        Map<String, Object> result = sysUserService.getSysUserList(pageNum, pageSize);
        return ResultMessage.success(result);
    }

    /**
     * @description 获取用户详情
     * @param userId
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @GetMapping("/getSysUserInfo")
    public ResultMessage getSysUserInfo(Integer userId) {
        SysUser result = sysUserService.getSysUserInfo(userId);
        return ResultMessage.success(result);
    }

    /**
     * @description 是否userCode已存在
     * @param userCode
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @PostMapping("/whetherTheUserCodeExist")
    public ResultMessage whetherTheUserCodeExist(String userCode) {
        boolean result = sysUserService.whetherTheUserCodeExist(userCode);
        return ResultMessage.success(result);
    }

    /**
     * @description 是否userEmail已存在
     * @param userEmail
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @PostMapping("/whetherTheUserEmailExist")
    public ResultMessage whetherTheUserEmailExist(String userEmail) {
        boolean result = sysUserService.whetherTheUserEmailExist(userEmail);
        return ResultMessage.success(result);
    }

    /**
     * @description 是否userTel已存在
     * @param userTel
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @PostMapping("/whetherTheUserTelExist")
    public ResultMessage whetherTheUserTelExist(String userTel) {
        boolean result = sysUserService.whetherTheUserTelExist(userTel);
        return ResultMessage.success(result);
    }
}
