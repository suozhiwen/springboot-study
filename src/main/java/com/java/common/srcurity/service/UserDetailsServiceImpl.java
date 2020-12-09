package com.java.common.srcurity.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.entity.SysUser;
import com.java.entity.vo.LoginUserVo;
import com.java.service.ISysUserService;
import com.java.service.SysPermissionService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户登录验证处理
 *
 * @author ruoyi
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUserName, username);
        SysUser user = userService.getOne(queryWrapper);

        if (null == user) {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
//        else if (UserStatus.DELETED.getCode().equals(user.getDelFlag()))
//        {
//            log.info("登录用户：{} 已被删除.", username);
//            throw new BaseException("对不起，您的账号：" + username + " 已被删除");
//        }
//        else if (UserStatus.DISABLE.getCode().equals(user.getStatus()))
//        {
//            log.info("登录用户：{} 已被停用.", username);
//            throw new BaseException("对不起，您的账号：" + username + " 已停用");
//        }

        return createLoginUser(user);
    }

    public LoginUserVo createLoginUser(SysUser user) {

        Set<String> permissions =  permissionService.getMenuPermission(user);
        LoginUserVo loginUser = new LoginUserVo(user,permissions);


//        Set authoritiesSet = new HashSet();
//        // 模拟从数据库中获取用户角色
//        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
//        authoritiesSet.add(authority);

        Set authoritiesSet = new HashSet();
        for (String o : permissions) {
            // 模拟从数据库中获取用户角色
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+o);
            authoritiesSet.add(authority);

        }


        loginUser.setAuthorities(authoritiesSet);
        return loginUser;
    }
}
