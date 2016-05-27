package com.service.live.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.live.LiveInfoDao;
import com.entity.live.LiveInfo;
import com.service.impl.BaseServiceImpl;
import com.service.live.LiveInfoService;

@Service("liveInfoService")
public class LiveInfoServiceImpl extends BaseServiceImpl<LiveInfo> implements LiveInfoService{
	LiveInfoDao liveInfoDao;
	@Autowired
	public LiveInfoServiceImpl(LiveInfoDao liveInfoDao) {
		super(liveInfoDao);
		System.out.println(liveInfoDao);
		this.liveInfoDao = liveInfoDao;
	}
}
