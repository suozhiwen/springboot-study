package com.java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.java.entity.SysUser;
import com.java.service.ISysUserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* <p>
*  前端控制器
* </p>
*
* @author szw
* @since 2020-10-20
*/
@RestController
@RequestMapping("//sys-user-api")
public class SysUserController  {


    @Autowired
    private ISysUserService iSysUserService;




}

