package com.zyx.service.live.impl;

import java.util.List;

import com.zyx.param.live.BarrageParam;
import com.zyx.vo.live.BarrageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.Barrage;
import com.zyx.mapper.live.BarrageMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.live.BarrageService;

@Service("barrageService")
public class BarrageServiceImpl extends BaseServiceImpl<Barrage> implements BarrageService {
	@Autowired
	BarrageMapper barrageMapper;

	public BarrageServiceImpl() {
		super(Barrage.class);
	}

	@Override
	public List<BarrageVo> getList(BarrageParam barrageParam) {
		if(barrageParam.getPager()!=null&&!barrageParam.getPager().verifyPager())
			barrageParam.setPager(null);
		return barrageMapper.selectList(barrageParam);
	}
}
