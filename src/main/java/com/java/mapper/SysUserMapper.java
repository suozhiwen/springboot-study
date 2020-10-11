package com.java.mapper;

import com.java.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 *  Mapper 接口
 *
 *
 * @author szw
 * @since 2020-10-11
 */

public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectSysUserList(SysUser parameter);

    SysUser selectEntity(SysUser parameter);

    Integer update(SysUser parameter);

    Integer insert(SysUser parameter);

    Integer deleteByIdById(@Param("id") Integer id);

    Integer deleteByIds(Integer[] ids);
}
