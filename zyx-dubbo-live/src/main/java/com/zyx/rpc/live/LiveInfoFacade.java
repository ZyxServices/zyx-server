package com.zyx.rpc.live;

import java.util.List;
import java.util.Map;

import com.zyx.entity.live.LiveInfo;
import com.zyx.entity.live.dto.LiveInfoDto;
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
	public void add(LiveInfo liveInfo);
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
	 * @param liveInfoVo
	 * @return
	 * @description 获取直播列表
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月22日 上午10:30:21
	 */
	public List<LiveInfoDto> getList(LiveInfoVo liveInfoVo);
	
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
	
	/**
	 * 获取首推
	 * @return
	 * @description TODO
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月29日 上午10:35:22
	 */
	public List<LiveInfo> getDevaLives();
	
	/**
	 * 刷新首推
	 * 
	 * @description TODO
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月29日 下午2:52:40
	 */
	public void refreshDevaLives();
	
	/**
	 * 添加首推
	 * @param lvieId
	 * @description TODO
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年7月4日 下午2:19:34
	 */
	public void addDevaLive(Integer lvieId);
	
	/**
	 * 首推个数
	 * @return
	 * @description TODO
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年7月4日 下午2:19:46
	 */
	public int countDevaLive();
	
	/**
	 * 首推 直播观看人数
	 * @return
	 * @description TODO
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年7月4日 下午2:39:12
	 */
	public Map<Integer,Integer>getLiveDevaWatchNum();
	/**
	 * 获取直播的观看人数
	 * @param liveIds
	 * @return
	 * @description TODO
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年7月4日 下午2:21:39
	 */
	public Map<Integer,Integer> getLiveWatchNum(List<Integer> liveIds);
}
