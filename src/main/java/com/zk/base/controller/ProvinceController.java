package com.zk.base.controller;

import com.zk.base.model.SysMenu;
import com.zk.base.service.SysMenuService;
import com.zk.base.utils.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Resource
    private SysMenuService sysMenuService;

    /**
     * @param menu
     * @return com.zk.base.utils.ResultMessage
     * @description 新增菜单
     * @author zengkui
     * @date 2021/4/10 8:31 下午
     */
    @PostMapping("/getProvinceList")
    public ResultMessage getProvinceList(@RequestBody SysMenu menu) {
        String result = sysMenuService.saveSysMenu(menu);
        return ResultMessage.success(result);
    }

}
