package com.java.common.test.test2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @ConfigurationProperties  支持松散绑定
 * 只需要指定一个前缀，就能绑定有这个前缀的所有属性值。
 */
@ConfigurationProperties(prefix = "person")
@Data
@Configuration
public class Person1 {

    private String lastName;

    private Integer age;

    private Boolean boss;

    private Date birth;

}