package com.zyx.rpc.live;

import java.util.List;
import java.util.Map;

import com.zyx.entity.live.LiveInfo;
import com.zyx.entity.live.dto.LiveInfoDto;
import com.zyx.param.live.LiveInfoParam;
import com.zyx.vo.live.LiveInfoVo;
import com.zyx.vo.live.LiveSearchVo;

/**
 *
 * @title LiveInfoFacade.java
 * @package com.zyx.rpc.live
 * @description TODO
 * @author DengQingHai
 * @update 2016年6月14日 下午3:17:07
 * @version V1.0
 * Copyright (c)2012 chantsoft-版权所有
 */
public interface LiveInfoFacade {
	/**
	 *
	 * @param liveInfo
	 * @description T添加直播 需要Token 验证
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:28:48
	 */
	public Integer add(LiveInfo liveInfo);
	/**
	 *
	 * @param liveInfo
	 * @description 更新直播 需要Token验证
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:29:15
	 */
	public void updateNotNull(LiveInfo liveInfo);
	/**
	 *
	 * @param id
	 * @return
	 * @description 获取直播 单个
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:30:44
	 */
	public LiveInfo getById(Integer id);

	/**
	 *
	 * @param id
	 * @return
	 */
	public LiveInfoVo endLive(Integer id);
	/**
	 *
	 * @param liveInfoParam
	 * @return
	 * @description 获取直播列表
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:30:21
	 */
	public List<LiveInfoVo> getList(LiveInfoParam liveInfoParam);
	/**
	 *
	 * @param id
	 * @description 删除直播 需要Token验证
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:30:06
	 */
	public void delete(Integer id);

	/**
	 *
	 * @param liveId
	 * @return
	 * @description 获取直播地址
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月27日 下午6:18:28
	 */
	public String getLiveUrl(Integer liveId);

//	/**
//	 * 获取直播的观看人数
//	 * @param liveIds
//	 * @return
//	 * @description TODO
//	 * @version 1.0
//	 * @author MrDeng
//	 * @update 2016年7月4日 下午2:21:39
//	 */
//	public Map<Integer,Integer> getLiveWatchNum(List<Integer> liveIds);


	/**
	 * 进入或者推出直播间
	 * @param liveId
	 * @param inOrOut
	 */
	public void  inOrOutLive(Integer liveId,Integer inOrOut);
}
