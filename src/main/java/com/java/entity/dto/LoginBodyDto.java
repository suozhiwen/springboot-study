package com.java.entity.dto;

import lombok.Data;

@Data
public class LoginBodyDto {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

}
