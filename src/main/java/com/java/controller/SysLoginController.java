package com.java.controller;

import com.java.common.srcurity.service.SysLoginService;
import com.java.entity.dto.LoginBodyDto;
import com.java.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
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

}
