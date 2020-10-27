package com.java.common.srcurity.service;

import com.java.common.redis.RedisCache;
import com.java.common.srcurity.token.TokenService;
import com.java.entity.vo.LoginUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验
 *
 * @author szw
 */
@Component
public class SysLoginService {

    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;


    @Autowired
    private RedisCache redisCache;
    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    public String login(String username, String password) {
        redisCache.setCacheObject("userName",username);
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoginUserVo loginUser = (LoginUserVo) authentication.getPrincipal();

        // 生成token
        return tokenService.createToken(loginUser);
    }

}
