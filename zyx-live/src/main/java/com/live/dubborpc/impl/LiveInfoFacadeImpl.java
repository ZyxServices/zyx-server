package com.live.dubborpc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.live.dubborpc.LiveInfoFacade;
import com.zyx.entity.live.LiveInfo;
import com.zyx.service.live.LiveInfoService;

@Service("liveInfoFacade")
public class LiveInfoFacadeImpl implements LiveInfoFacade {

	@Autowired
	LiveInfoService liveInfoService;

	@Override
	public void create(LiveInfo  liveInfo) {

		liveInfoService.save(liveInfo);
	}

//	@Override
//	public LiveInfo getById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
