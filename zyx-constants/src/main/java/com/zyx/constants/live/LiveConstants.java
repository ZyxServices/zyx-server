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

	String MARK_REDIS_LIVE_LAB_LIST = "lab_list";
	String MARK_HASH_REDIS_LAB_TYPE_LIST = "hash_lab_list";

	String MARK_REDIS_BARRAGE_QUEUE = "barrage";
	String HASH_REDIS_BARRAGE_QUEUE = "hash_barrage";
	/**
	 * 弹幕默认最大缓存数量
	 */
	long REDIS_MAX_BARRAGE_QUEUE_SIZE = 10000;

	/**
	 * 批量存储弹幕 条数阈值  测试实则为5
	 */
	// TODO: 2016/8/3 正式时修改该数值
	long CACHE_BATACH_SAVE_PROFIXE = 5;
	String MARK_REDIS_BARRAGE_SIZE = "b_size";
}
