package com.mobileservice.dubborpc;

import com.mobileservice.entity.User;

public interface UserFacade {
	
		public void create(User user);
		
		public User getById(Long userId);

}
