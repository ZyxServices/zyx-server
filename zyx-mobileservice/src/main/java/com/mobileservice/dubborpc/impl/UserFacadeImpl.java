package com.mobileservice.dubborpc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileservice.dubborpc.UserFacade;
import com.mobileservice.entity.User;
import com.mobileservice.service.UserService;
@Service("userFacade")
public class UserFacadeImpl implements UserFacade {
	@Autowired
	private UserService userService;
	@Override
	public void create(User user) {
		userService.create(user);

	}

	@Override
	public User getById(Long userId) {
		return userService.getById(userId);
	}

}
