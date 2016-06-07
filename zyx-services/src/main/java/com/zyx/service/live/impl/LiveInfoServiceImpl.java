package com.zyx.service.live.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.dao.live.LiveInfoDao;
import com.zyx.entity.live.LiveInfo;
import com.zyx.service.impl.BaseServiceImpl;
import com.zyx.service.live.LiveInfoService;

@Service("liveInfoService")
public class LiveInfoServiceImpl extends BaseServiceImpl<LiveInfo> implements LiveInfoService{
	LiveInfoDao liveInfoDao;
	@Autowired
	public LiveInfoServiceImpl(LiveInfoDao liveInfoDao) {
		super(liveInfoDao);
		this.liveInfoDao = liveInfoDao;
	}

}
