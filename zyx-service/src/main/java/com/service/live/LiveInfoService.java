package com.service.live;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.live.LiveInfoDao;
import com.entity.live.LiveInfo;
import com.service.impl.BaseServiceImpl;

@Service("liveInfoService")
public class LiveInfoService extends BaseServiceImpl<LiveInfo>{
	LiveInfoDao liveInfoDao;
	@Autowired
	public LiveInfoService(LiveInfoDao liveInfoDao) {
		super(liveInfoDao);
		this.liveInfoDao = liveInfoDao;
	}
}
