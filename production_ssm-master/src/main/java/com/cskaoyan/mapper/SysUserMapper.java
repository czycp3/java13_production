package com.cskaoyan.mapper;

import com.cskaoyan.bean.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 16:25
 */
public interface SysUserMapper {

    SysUser findByUsername(@Param("username") String username);
}
