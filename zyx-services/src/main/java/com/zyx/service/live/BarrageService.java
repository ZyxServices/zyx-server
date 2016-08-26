package com.zyx.service.live;

import java.util.List;

import com.zyx.entity.live.Barrage;
import com.zyx.param.live.BarrageParam;
import com.zyx.service.BaseService;
import com.zyx.vo.live.BarrageVo;

public interface BarrageService extends BaseService<Barrage> {
	public List<Barrage> getList(BarrageParam barrageParam);
}
