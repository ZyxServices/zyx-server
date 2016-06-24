package com.zyx.vo.live;

import com.zyx.vo.BaseVo;


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
	private Long createTimeLower;
	private Long createTimeUpper;


	public Long getLiveId() {
		return liveId;
	}

	public void setLiveId(Long liveId) {
		this.liveId = liveId;
	}

	public Long getCreateTimeLower() {
		return createTimeLower;
	}

	public void setCreateTimeLower(Long createTimeLower) {
		this.createTimeLower = createTimeLower;
	}

	public Long getCreateTimeUpper() {
		return createTimeUpper;
	}

	public void setCreateTimeUpper(Long createTimeUpper) {
		this.createTimeUpper = createTimeUpper;
	}
}
