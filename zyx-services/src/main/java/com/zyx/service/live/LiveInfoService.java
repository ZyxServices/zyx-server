package com.zyx.service.live;

import java.util.List;

import com.zyx.entity.live.LiveInfo;
import com.zyx.entity.live.dto.LiveInfoDto;
import com.zyx.param.live.LiveInfoParam;
import com.zyx.service.BaseService;
import com.zyx.vo.live.LiveInfoVo;

public interface LiveInfoService extends BaseService<LiveInfo> {
	
	public Long countLive(LiveInfoParam param);

	public List<LiveInfoVo> selectLives(LiveInfoParam param);

	public void logicDelete(Integer id);
}
