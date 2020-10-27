package com.java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.java.entity.SysMenu;
import com.java.service.ISysMenuService;
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




}

