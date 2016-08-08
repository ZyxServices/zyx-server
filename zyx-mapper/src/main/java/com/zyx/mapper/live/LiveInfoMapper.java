package com.zyx.mapper.live;

import java.util.List;

import com.zyx.entity.live.dto.LiveInfoDto;
import org.springframework.stereotype.Repository;

import com.zyx.entity.live.LiveInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.live.LiveInfoVo;

@Repository("liveTypeMapper")
public interface LiveInfoMapper extends BaseMapper<LiveInfo> {
	public int countLives(LiveInfoVo vo);
	public List<LiveInfoDto> selectLives(LiveInfoVo vo);
}
