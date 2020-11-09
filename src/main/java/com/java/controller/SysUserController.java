package com.java.controller;

import com.java.common.web.Exception.BaseException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.java.entity.SysUser;
import com.java.service.ISysUserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* <p>
* 用户信息表 前端控制器
* </p>
*
* @author szw
* @since 2020-10-25
*/
@RestController
@RequestMapping("/sys-user-api")
public class SysUserController  {


    @Autowired
    private ISysUserService iSysUserService;


//    @PreAuthorize("hasAuthority('admin')")
    @GetMapping
    public List<SysUser> sysUserList() {
        List<SysUser> sysUserList = iSysUserService.list();
        if (sysUserList.size() < 100000){
            throw new BaseException("500","用户名或者密码错误");
        }
        for (SysUser sysUser : sysUserList) {
            System.out.println(sysUser.toString());
        }
        return sysUserList;
    }


}

