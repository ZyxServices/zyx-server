package com.zyx.service.live;

import java.util.List;

import com.zyx.entity.live.LiveInfo;
import com.zyx.entity.live.dto.LiveInfoDto;
import com.zyx.service.BaseService;
import com.zyx.vo.live.LiveInfoVo;

public interface LiveInfoService extends BaseService<LiveInfo> {
	
	public int countLive(LiveInfoVo vo);
	/**
	 * 获取直播 分页
	 * @param vo
	 * @return
	 * @description TODO
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月29日 上午10:35:42
	 */
	public List<LiveInfoDto> selectLives(LiveInfoVo vo);
	
	public List<LiveInfo> selectLiveDevas(List<Integer> ids);

	public void logicDelete(Integer id);
}
