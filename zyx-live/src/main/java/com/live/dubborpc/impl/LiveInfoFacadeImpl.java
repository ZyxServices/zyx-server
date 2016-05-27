package com.live.dubborpc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.LiveInfo;
import com.live.dubborpc.LiveInfoFacade;

@Service("liveInfoFacade")
public class LiveInfoFacadeImpl implements LiveInfoFacade {

	@Autowired
//	LiveInfoService
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LiveInfo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
