package com.zyx.service.live.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.LiveInfo;
import com.zyx.mapper.live.LiveInfoMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.live.LiveInfoService;
import com.zyx.vo.live.LiveInfoVo;

@Service("liveInfoService")
public class LiveInfoServiceImpl extends BaseServiceImpl<LiveInfo> implements LiveInfoService {

	@Autowired
	LiveInfoMapper liveInfoMapper;
	@Override
	public int countLive(LiveInfoVo vo) {
		return liveInfoMapper.countLives(vo);
	}
	@Override
	public List<LiveInfo> selectLives(LiveInfoVo vo) {
		return liveInfoMapper.selectLives(vo);
	}

	
}
