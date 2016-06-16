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
	 * 直播不存在
	 */
	String MSG_LIVE_NOT_EXIST = "this live is not exist";
}
