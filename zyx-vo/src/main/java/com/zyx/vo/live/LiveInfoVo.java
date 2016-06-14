package com.zyx.vo.live;

import com.zyx.vo.BaseVo;

public class LiveInfoVo extends BaseVo {

	private Long createTime;
	private Integer type;
	private Long start;
	private Long end;
	private Integer lab;
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Long getEnd() {
		return end;
	}
	public void setEnd(Long end) {
		this.end = end;
	}
	public Integer getLab() {
		return lab;
	}
	public void setLab(Integer lab) {
		this.lab = lab;
	}
	
	
	

}
