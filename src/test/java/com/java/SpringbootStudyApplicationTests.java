package com.java;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.common.redis.RedisCache;
import com.java.common.test.test1.Car;
import com.java.common.test.test1.Driver;
import com.java.entity.SysUser;
import com.java.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootStudyApplicationTests {

	@Autowired
    SysUserMapper mapper;

	@Resource
	RedisCache redisCache;

	@Test
	void contextLoads() {
		//分页
		IPage<SysUser> sysUsersList =  mapper.selectPage(new Page<SysUser>(1, 2),null);
		List<SysUser> sysUserList = sysUsersList.getRecords();
		for (SysUser user : sysUserList) {
			System.out.println(user);
		}
		redisCache.setCacheList("IPage_1",sysUserList);
//		mapper.insert(sysUser);

	}



}
