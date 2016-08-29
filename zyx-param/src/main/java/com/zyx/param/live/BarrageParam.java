package com.zyx.param.live;

import java.io.Serializable;

/**
 * 
 * @title Barrage.java
 * @package com.zyx.entity.live
 * @description 弹幕内容
 * @author MrDeng   
 * @update 2016年6月22日 上午11:13:45
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public class BarrageParam implements Serializable{

	 /**serialVersionUID TODO*/
	private static final long serialVersionUID = 1L;
	private Integer liveId;
//    private Long createTimeLower;
//    private Long createTimeUpper;

	private Long index;

	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

	public Integer getLiveId() {
		return liveId;
	}

	public void setLiveId(Integer liveId) {
		this.liveId = liveId;
	}

//	public Long getCreateTimeLower() {
//		return createTimeLower;
//	}
//
//	public void setCreateTimeLower(Long createTimeLower) {
//		this.createTimeLower = createTimeLower;
//	}
//
//	public Long getCreateTimeUpper() {
//		return createTimeUpper;
//	}
//
//	public void setCreateTimeUpper(Long createTimeUpper) {
//		this.createTimeUpper = createTimeUpper;
//	}


    

}