package com.cskaoyan.service.impl;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.mapper.SysUserMapper;
import com.cskaoyan.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 16:24
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;


    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.findByUsername(username);
    }
}
