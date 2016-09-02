package com.zyx.mapper.live;

import java.util.List;

import com.zyx.param.live.BarrageParam;
import com.zyx.vo.live.BarrageVo;
import org.springframework.stereotype.Repository;

import com.zyx.entity.live.Barrage;
import com.zyx.mapper.BaseMapper;

@Repository("barrageMapper")
public interface BarrageMapper extends BaseMapper<Barrage> {
	public List<BarrageVo> selectList(BarrageParam barrageParam);
}
