package com.zyx.rpc.live.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.Barrage;
import com.zyx.rpc.live.BarrageFacade;
import com.zyx.service.live.BarrageService;
import com.zyx.vo.live.BarrageVo;

@Service("barrageFacade")
public class BarrageFacadeImpl implements BarrageFacade{

	@Autowired
	BarrageService barrageService;
	@Override
	public void add(String token, Barrage barrage) {
		barrageService.save(barrage);
	}

	@Override
	public List<Barrage> getLast(BarrageVo barrageVo) {
		return barrageService.getTop(barrageVo);
	}
	
}
