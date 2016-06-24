package com.zyx.rpc.live;

import java.util.List;

import com.zyx.entity.live.TextLiveItem;
import com.zyx.vo.live.TextLiveItemVo;

/**
 * 
 * @title TextLiveItemFacade.java
 * @package com.zyx.rpc.live
 * @description TODO
 * @author MrDeng   
 * @update 2016年6月15日 下午2:07:28
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public interface TextLiveItemFacade {
	/**
	 * 创建直播 内容
	 * @param liveInfo
	 */
	public void add(TextLiveItem liveInfo);
	
//	public void update(TextLiveItem liveInfo);
	/**
	 * 获取单条 直播内容
	 * @param id
	 * @return
	 */
	public TextLiveItem getById(Long id);
	/**
	 * 获取直播内容列表
	 * @param liveInfoVo
	 * @return
	 */
	public List<TextLiveItem> getList( TextLiveItemVo textLiveItemVo);

	/**
	 * 
	 * @param id
	 * @version 1.0
	 * @author MrDeng
	 * @update 2016年6月15日 下午2:07:23
	 */
	public void deleteById(Long id);
}
