package com.mobileservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileservice.dao.UserDao;
import com.mobileservice.entity.User;

@Service("userService")
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void create(User user) {
		userDao.insert(user);
	}
	
	public User getById(Long userId) {
		return userDao.getById(userId);
	}
	/*
	 * ..................
	 * 
	 */
}
