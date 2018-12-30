package org.shop.service;

import org.shop.pojo.User;

public interface UserService {

	int selectLogin(User user);
	
	int update(User user);
}
