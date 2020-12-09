package com.java.controller;

import com.java.common.srcurity.service.SysLoginService;
import com.java.entity.dto.LoginBodyDto;
import com.java.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysLoginController {


    @Autowired
    private SysLoginService loginService;


    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBodyDto loginBody) {
        AjaxResult ajax = AjaxResult.success();

        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        ajax.put("token", token);
        return ajax;
    }


    @GetMapping(value = "geta")
    @PreAuthorize("hasAnyRole('ROLE_system:user:list')")
    public String a() {
        return "1234";
    }

    @GetMapping(value = "getb")
    @PreAuthorize("hasAuthority('ROLE_system:user:list')")
    public String b() {
        return "2345";
    }

    @GetMapping(value = "getc")
    public String C() {
        final String currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        System.out.println(currentUser);
        return "2345";
    }
}
