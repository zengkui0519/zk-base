package com.zk.base.controller;

import com.zk.base.model.request.UserReqParam;
import com.zk.base.model.vo.SysUserVO;
import com.zk.base.service.SysUserService;
import com.zk.base.utils.ResultMessage;
import com.zk.base.utils.SysConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysUserService sysUserService;

    /**
     * @param user
     * @return com.zk.base.utils.ResultMessage
     * @description 添加用户
     * @author zengkui
     * @date 2021/4/10 8:19 下午
     */
    @PostMapping("/saveSysUser")
    public ResultMessage saveSysUser(@RequestBody SysUserVO user) {
        String result = sysUserService.saveSysUser(user);
        if (SysConstants.Public.SUCCESS.equals(result)) {
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result);
    }

    /**
     * @param user
     * @return com.zk.base.utils.ResultMessage
     * @description 更新用户
     * @author zengkui
     * @date 2021/4/10 8:20 下午
     */
    @PostMapping("/updateSysUser")
    public ResultMessage updateSysUser(@RequestBody SysUserVO user) {
        String result = sysUserService.updateSysUser(user);
        if (SysConstants.Public.SUCCESS.equals(result)) {
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result);
    }

    /**
     * @param userId
     * @return com.zk.base.utils.ResultMessage
     * @description 删除用户
     * @author zengkui
     * @date 2021/4/10 8:20 下午
     */
    @PostMapping("/deleteSysUser")
    public ResultMessage deleteSysUser(Integer userId) {
        logger.info("deleteSysUser userId: {}", userId);
        String result = sysUserService.deleteSysUser(userId);
        if (SysConstants.Public.SUCCESS.equals(result)) {
            return ResultMessage.success(result);
        }
        return ResultMessage.fail(result);
    }

    /**
     * @param
     * @return com.zk.base.utils.ResultMessage
     * @description 分页获取用户列表
     * @author zengkui
     * @date 2021/4/10 8:20 下午
     */
    @GetMapping("/getSysUserList")
    public ResultMessage getSysUserList(UserReqParam reqParam) {
        Map<String, Object> result = sysUserService.getSysUserList(reqParam);
        return ResultMessage.success(result);
    }

    /**
     * @param userId
     * @return com.zk.base.utils.ResultMessage
     * @description 获取用户详情
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @GetMapping("/getSysUserInfo")
    public ResultMessage getSysUserInfo(Integer userId) {
        SysUserVO result = sysUserService.getSysUserInfo(userId);
        return ResultMessage.success(result);
    }

    /**
     * @param userCode
     * @return com.zk.base.utils.ResultMessage
     * @description 是否userCode已存在
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @PostMapping("/whetherTheUserCodeExist")
    public ResultMessage whetherTheUserCodeExist(Integer userId, String userCode) {
        boolean result = sysUserService.whetherTheUserCodeExist(userId, userCode);
        return ResultMessage.success(result);
    }

    /**
     * @param userEmail
     * @return com.zk.base.utils.ResultMessage
     * @description 是否userEmail已存在
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @PostMapping("/whetherTheUserEmailExist")
    public ResultMessage whetherTheUserEmailExist(Integer userId, String userEmail) {
        boolean result = sysUserService.whetherTheUserEmailExist(userId, userEmail);
        return ResultMessage.success(result);
    }

    /**
     * @param userTel
     * @return com.zk.base.utils.ResultMessage
     * @description 是否userTel已存在
     * @author zengkui
     * @date 2021/4/10 8:21 下午
     */
    @PostMapping("/whetherTheUserTelExist")
    public ResultMessage whetherTheUserTelExist(Integer userId, String userTel) {
        boolean result = sysUserService.whetherTheUserTelExist(userId, userTel);
        return ResultMessage.success(result);
    }
}
