package com.java;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.SysUser;
import com.java.mapper.SysUserMapper;
import org.apache.ibatis.session.RowBounds;
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
		SysUser sysUser =new SysUser();
//		sysUser.setName(null);
		sysUser.setAge(1234);
//		UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper();
//		updateWrapper.lambda().eq(SysUser::getId,"1318541929886773249");
//		mapper.update(sysUser,updateWrapper);

		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		//queryWrapper.lambda().select(需要显示的值)
		queryWrapper.lambda().select(SysUser::getEmail,SysUser::getEmail);
//		List<SysUser> sysUsersList = mapper.selectList(queryWrapper);

		//分页
		IPage<SysUser> sysUsersList =  mapper.selectPage(new Page<SysUser>(1, 2),queryWrapper);
		List<SysUser> sysUserList = sysUsersList.getRecords();
		for (SysUser user : sysUserList) {
			System.out.println(user);
		}
//		mapper.insert(sysUser);

	}

}
