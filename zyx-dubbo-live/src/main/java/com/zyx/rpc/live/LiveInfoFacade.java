package com.zyx.rpc.live;

import java.util.List;

import com.zyx.entity.live.LiveInfo;
import com.zyx.vo.live.LiveInfoVo;

public interface LiveInfoFacade {
	public void add(LiveInfo liveInfo);
	public void update(LiveInfo liveInfo);
	public LiveInfo getById(long id);
	public List<LiveInfo> getList( LiveInfoVo liveInfoVo);
}
