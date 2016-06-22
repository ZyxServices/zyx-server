package com.zyx.mapper.live;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyx.entity.live.Barrage;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.live.BarrageVo;

@Repository("barrageMapper")
public interface BarrageMapper extends BaseMapper<Barrage> {
	public List<Barrage> selectTop(BarrageVo vo);
}
