package com.zyx.service.live.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.Barrage;
import com.zyx.mapper.live.BarrageMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.live.BarrageService;
import com.zyx.vo.live.BarrageVo;

@Service("barrageService")
public class BarrageServiceImpl extends BaseServiceImpl<Barrage> implements BarrageService {
	@Autowired
	BarrageMapper barrageMapper;

	@Override
	public List<Barrage> getTop(BarrageVo vo) {
		return barrageMapper.selectTop(vo);
	}
}
