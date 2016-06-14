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
	public void add(LiveInfo liveInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LiveInfo liveInfo) {
		// TODO Auto-generated method stub
		
	}



}
