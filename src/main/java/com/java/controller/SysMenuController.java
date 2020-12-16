package com.java.controller;

import com.java.entity.SysMenu;
import com.java.service.ISysMenuService;
import com.java.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* <p>
* 菜单权限表 前端控制器
* </p>
*
* @author szw
* @since 2020-10-25
*/
@RestController
@RequestMapping("/sys-menu-api")
public class SysMenuController  {


    @Autowired
    private ISysMenuService iSysMenuService;

    @GetMapping
    public AjaxResult list(SysMenu sysMenu){
        List<SysMenu> sysMenuList = iSysMenuService.list();
        return AjaxResult.success(sysMenuList);
    }

}

