package com.zyx.vo.common;

import com.zyx.vo.BaseVo;

/**
 * 
 * @title SearchVo.java
 * @package com.zyx.vo.common
 * @description 搜索使用VO
 * @author MrDeng   
 * @update 2016年6月22日 下午5:47:00
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public class SearchVo extends BaseVo {

	
	 /**serialVersionUID TODO*/ 
	
	private static final long serialVersionUID = 1L;
	private String keyWord;
	private String model;
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
