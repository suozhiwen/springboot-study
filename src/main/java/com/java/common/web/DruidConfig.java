package com.java.common.web;

import com.alibaba.druid.support.http.StatViewServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Druid数据库连接池配置文件
 */
@Configuration
public class DruidConfig {
    private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(new StatViewServlet());
        registrationBean.setUrlMappings(Collections.singletonList("/druid/*"));
        //设置初始化参数
        Map<String, String> initMap = new HashMap<>();
        // 登录账户密码
        initMap.put("loginUsername", "admin");
        initMap.put("loginPassword", "admin123");
        initMap.put("allow", "");
        initMap.put("deny", "");
        registrationBean.setInitParameters(initMap);
        return registrationBean;
    }

}
