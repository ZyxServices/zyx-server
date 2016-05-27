package com.mobileservice.dao;

import com.zyx.dao.BaseDao;
import com.mobileservice.entity.User;

public interface UserDao extends BaseDao<User>  {
	
	
	User findByUserName(String name);
}
