package com.zyx.constants.live;

import com.zyx.constants.Constants;

/**
 * 
 * @title LiveHttpCode.java
 * @package com.zyx.constants.live
 * @description 直播模块 http 请求 代码 
 * 代码范围20000~29999
 * 消息开头 MSG_LIVE
 * @author MrDeng   
 * @update 2016年6月16日 上午11:30:16
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public interface LiveConstants extends Constants{

	
	/**
	 * 不存在的直播
	 */
	int LIVE_NOT_EXIST = 20001;
	
	/**
	 * 用户为实名认证
	 */
	int LIVE_NOT_REAL_NAME = 23000;
	
	////////////////////////////24000~24999参数问题
	int LIVE_BARRAGE_NULL_CONTENT=24000;
	
	/**
	 * 直播不存在
	 */
	String MSG_LIVE_NOT_EXIST = "当前直播不存在";
	
	String MSG_LIVE_BARRAGE_NULL_CONTENT = "直播弹幕无消息内容";
	
	
	
	
	int PAGE_LAB_PAGE_SIZE= 4;
	
	int MARK_LIVE_DEVA_MODEL= 2;
	int MARK_LIVE_DEVA_COUNT= 4;

	///////////////////////REDIS KEYS////////////////////////////
	String MARK_LIVE_DEVA = "liveDeva";
	String MARK_HASH_LIVE_DEVA = "hash_liveDeva";
	String MARK_REDIS_LIVE_TYPE_LIST = "lt_list";
	String MARK_HASH_REDIS_LIVE_TYPE_LIST = "hash_lt_list";
}
