package com.zyx.rpc.live.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.LiveInfo;
import com.zyx.rpc.live.LiveInfoFacade;
import com.zyx.service.live.LiveInfoService;
import com.zyx.vo.live.LiveInfoVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service("liveInfoFacade")
public class LiveInfoFacadeImpl implements LiveInfoFacade {

	@Autowired
	LiveInfoService liveInfoService;

	@Override
	public void add(LiveInfo liveInfo) {

		liveInfoService.save(liveInfo);
	}

	@Override
	public void update(LiveInfo liveInfo) {
		liveInfoService.updateNotNull(liveInfo);
	}

	@Override
	public LiveInfo getById(long id) {
		return liveInfoService.selectByKey(id);
	}

	@Override
	public List<LiveInfo> getList( LiveInfoVo liveInfoVo) {
		Example example = new Example(LiveInfo.class);
		Criteria criteria = example.createCriteria();
		if(null!=liveInfoVo.getType()){
			criteria.andEqualTo("type", liveInfoVo.getType());
		}
		return liveInfoService.selectByExample(example);
	}

}
