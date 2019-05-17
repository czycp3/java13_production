package com.cskaoyan.service.impl;

import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.service.UserService;
import org.springframework.stereotype.Service;

/**
 *
 * @author CZY-Y7000P
 */
@Service
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;


	@Override
	public boolean login(String username, String password) {
		return false;
	}
}
