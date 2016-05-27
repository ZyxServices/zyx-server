package com.mobileservice.dao.impl;

import org.springframework.stereotype.Repository;

import com.zyx.dao.BaseDaoImpl;
import com.mobileservice.dao.UserDao;
import com.mobileservice.entity.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findByUserName(String name) {
		return super.getSqlSession().selectOne(getStatement("findByUserNname"), name);
	}


}
