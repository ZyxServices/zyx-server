package com.zyx.vo.live;

import com.zyx.vo.common.SearchVo;

public class LiveSearchVo extends SearchVo{

	
	 /**serialVersionUID TODO*/ 
	
	private static final long serialVersionUID = 1L;
	private Integer lab;
	private String name;
	public Integer getLab() {
		return lab;
	}
	public void setLab(Integer lab) {
		this.lab = lab;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
