package org.shop.service.impl;

import org.shop.dao.UserMapper;
import org.shop.pojo.User;
import org.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	@Override
	public int selectLogin(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectLogin(user);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByName(user);
	}
}
