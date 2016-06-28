package com.zyx.vo.live;

import com.zyx.vo.BaseVo;

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
public class BarrageVo extends BaseVo{

    
	 /**serialVersionUID TODO*/ 
	
	private static final long serialVersionUID = 1L;

	private Long liveId;
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
