package com.zyx.service.live.impl;

import com.zyx.entity.live.LiveLab;
import com.zyx.mapper.live.LiveLabMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.live.LiveLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("liveLabService")
public class LiveLabServiceImpl extends BaseServiceImpl<LiveLab> implements LiveLabService {

	@Autowired
	LiveLabMapper liveLabMapper ;

	public LiveLabServiceImpl() {
		super(LiveLab.class);
	}

	@Override
	public List<String> getAllTypes() {
		return liveLabMapper.getAllLabs();
	}
}
