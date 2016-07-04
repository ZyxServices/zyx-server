package com.zyx.service.live.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.LiveInfo;
import com.zyx.mapper.live.LiveInfoMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.live.LiveInfoService;
import com.zyx.vo.live.LiveInfoVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service("liveInfoService")
public class LiveInfoServiceImpl extends BaseServiceImpl<LiveInfo> implements LiveInfoService {

	@Autowired
	LiveInfoMapper liveInfoMapper ;
	@Override
	public int countLive(LiveInfoVo vo) {
		return liveInfoMapper.countLives(vo);
	}
	@Override
	public List<LiveInfo> selectLives(LiveInfoVo vo) {
		return liveInfoMapper.selectLives(vo);
	}
	@Override
	public List<LiveInfo> selectLiveDevas(List<Integer> ids) {
		if(ids==null||ids.isEmpty())
			return null;
		else{
			Example example = new Example(LiveInfo.class);
			Criteria criteria = example.createCriteria();
			criteria.andIn("id", ids);
			return liveInfoMapper.selectByExample(example);
		}
	}
}
