package com.zyx.param.live;

import com.zyx.param.Pager;

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

	private Pager pager;
	public Integer getLiveId() {
		return liveId;
	}

	public void setLiveId(Integer liveId) {
		this.liveId = liveId;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
}
