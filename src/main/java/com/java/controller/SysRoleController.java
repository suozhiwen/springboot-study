package com.java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.java.entity.SysRole;
import com.java.service.ISysRoleService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* <p>
* 角色信息表 前端控制器
* </p>
*
* @author szw
* @since 2020-10-25
*/
@RestController
@RequestMapping("/sys-role-api")
public class SysRoleController  {


    @Autowired
    private ISysRoleService iSysRoleService;




}

