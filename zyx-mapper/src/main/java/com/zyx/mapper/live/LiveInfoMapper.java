package com.zyx.mapper.live;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyx.entity.live.LiveInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.live.LiveInfoVo;

@Repository("liveInfoMapper")
public interface LiveInfoMapper extends BaseMapper<LiveInfo> {
	public int countLives(LiveInfoVo vo);
	public List<LiveInfo> selectLives(LiveInfoVo vo);
}
