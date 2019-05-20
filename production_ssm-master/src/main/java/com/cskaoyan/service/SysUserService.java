package com.cskaoyan.service;

import com.cskaoyan.bean.SysUser;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 16:24
 */
public interface SysUserService {
    SysUser findByUsername(String username);
}
