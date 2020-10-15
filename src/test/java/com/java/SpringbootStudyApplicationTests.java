package com.java;
import com.java.entity.SysUser;
import com.java.mapper.SysUserMapper;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootStudyApplicationTests {

	@Autowired
    SysUserMapper mapper;

	@Test
	void contextLoads() {
		System.out.println(("----- selectAll method test ------"));
		SysUser sysUser =new SysUser();
		sysUser.setName("123");
		mapper.insert(sysUser);
		List<SysUser> sysUserList = mapper.selectList(null);
//		Assert.assertEquals(7, sysUserList.size());
		sysUserList.forEach(System.out::println);
	}

}
