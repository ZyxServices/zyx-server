package com.zyx.vo.live;

import com.zyx.vo.BaseVo;
import com.zyx.vo.common.TimeAreaVo;


/**
 * 
 * @title TextLiveItemVo.java
 * @package com.zyx.vo.live
 * @description TODO
 * @author MrDeng   
 * @update 2016年6月15日 上午11:26:44
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public class TextLiveItemVo extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 内容所属的直播ID
	 */
	private Long liveId;
	
	/**
	 * 查询时间范围 开始时间
	 */
	private TimeAreaVo createTime;


	public Long getLiveId() {
		return liveId;
	}

	public void setLiveId(Long liveId) {
		this.liveId = liveId;
	}

	public TimeAreaVo getCreateTime() {
		return createTime;
	}

	public void setCreateTime(TimeAreaVo createTime) {
		this.createTime = createTime;
	}


}
