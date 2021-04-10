package com.zk.base.controller;

import com.zk.base.model.SysMenu;
import com.zk.base.service.SysMenuService;
import com.zk.base.utils.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;

    /**
     * @description 获取所有菜单（查询树结构）,分配角色菜单时使用
     * @param
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 4:55 下午
     */
    @GetMapping("/getAllSysMenuList")
    public ResultMessage getAllSysMenuList() {
        List<SysMenu> result = sysMenuService.getAllSysMenuList();
        return ResultMessage.success(result);
    }

    /**
     * @description
     * @param
     * @return com.zk.base.utils.ResultMessage
     * @author zengkui
     * @date 2021/4/10 4:59 下午
     */
    @GetMapping("/getSysMenuListByPId")
    public ResultMessage getSysMenuListByPId() {
        List<SysMenu> result = sysMenuService.getSysMenuListByPId();
        return ResultMessage.success(result);
    }

    @PostMapping("/saveSysMenu")
    public ResultMessage saveSysMenu(@RequestBody SysMenu menu) {
        String result = sysMenuService.saveSysMenu(menu);
        return ResultMessage.success(result);
    }

    @PostMapping("/updateSysMenu")
    public ResultMessage updateSysMenu(@RequestBody SysMenu menu) {
        String result = sysMenuService.updateSysMenu(menu);
        return ResultMessage.success(result);
    }

    @PostMapping("/deleteSysMenu")
    public ResultMessage deleteSysMenu(Integer menuId) {
        String result = sysMenuService.deleteSysMenu(menuId);
        return ResultMessage.success(result);
    }

    @GetMapping("/getSysMenuInfo")
    public ResultMessage getSysMenuInfo(Integer menuId) {
        SysMenu result = sysMenuService.getSysMenuInfo(menuId);
        return ResultMessage.success(result);
    }

}