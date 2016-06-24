package com.zyx.rpc.live;

import java.util.List;

import com.zyx.entity.live.LiveInfo;
import com.zyx.vo.live.LiveInfoVo;
import com.zyx.vo.live.LiveSearchVo;

public interface LiveInfoFacade {
	/**
	 * 
	 * @param liveInfo
	 * @description T添加直播 需要Token 验证
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:28:48
	 */
	public void add(String token,LiveInfo liveInfo);
	/**
	 * 
	 * @param liveInfo
	 * @description 更新直播 需要Token验证
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:29:15
	 */
	public void updateNotNull(String token,LiveInfo liveInfo);
	/**
	 * 
	 * @param id
	 * @return
	 * @description 获取直播 单个
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:30:44
	 */
	public LiveInfo getById(Long id);
	/**
	 * 
	 * @param liveInfoVo
	 * @return
	 * @description 获取直播列表
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:30:21
	 */
	public List<LiveInfo> getList( LiveInfoVo liveInfoVo);
	
	/**
	 * 
	 * @param liveSearchVo
	 * @return
	 * @description 搜索直播列表
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午11:12:10
	 */
	public List<LiveInfo> searchList( LiveSearchVo liveSearchVo);
	/**
	 * 
	 * @param token
	 * @param id
	 * @description 删除直播 需要Token验证
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:30:06
	 */
	public void delete(String token,Long id);
}
