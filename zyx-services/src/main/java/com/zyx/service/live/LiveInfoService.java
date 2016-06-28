package com.zyx.service.live;

import java.util.List;

import com.zyx.entity.live.LiveInfo;
import com.zyx.service.BaseService;
import com.zyx.vo.live.LiveInfoVo;

public interface LiveInfoService extends BaseService<LiveInfo> {
	public int countLive(LiveInfoVo vo);
	public List<LiveInfo> selectLives(LiveInfoVo vo);
}
