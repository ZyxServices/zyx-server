package com.zyx.mapper.live;

import java.util.List;

import com.zyx.entity.live.dto.LiveInfoDto;
import com.zyx.param.live.LiveInfoParam;
import org.springframework.stereotype.Repository;

import com.zyx.entity.live.LiveInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.live.LiveInfoVo;

@Repository("liveInfoMapper")
public interface LiveInfoMapper extends BaseMapper<LiveInfo> {
	public int countLives(LiveInfoParam param);
	public List<LiveInfoVo> selectLives(LiveInfoParam param);
}
