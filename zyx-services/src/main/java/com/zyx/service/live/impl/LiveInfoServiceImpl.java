package com.zyx.service.live.impl;

import java.util.List;

import com.zyx.entity.live.dto.LiveInfoDto;
import com.zyx.param.live.LiveInfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
	public LiveInfoServiceImpl() {
		super(LiveInfo.class);
	}

	@Override
	public void saveLiveInfo(LiveInfo liveInfo) {
		liveInfoMapper.saveLiveInfo(liveInfo);
	}

	@Override
	public Long countLive(LiveInfoParam param) {
		return liveInfoMapper.countLives(param);
	}
	@Override
	public List<LiveInfoVo> selectLives(LiveInfoParam param) {
		if(param.getPager()!=null&&param.getPager().getPageSize()!=null&&param.getPager().getOffset()!=null){
			param.getPager().setCount(liveInfoMapper.countLives(param));
		}
		return liveInfoMapper.selectLives(param);
	}
	@Override
	public void logicDelete(Integer id) {
		LiveInfo liveInfo = new LiveInfo();
		liveInfo.setId(id);
		liveInfo.setDel(-1);
		updateNotNull(liveInfo);
	}


}
