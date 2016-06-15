package com.zyx.vo.live;

import java.util.List;

import com.zyx.vo.BaseVo;
import com.zyx.vo.common.TimeAreaVo;

public class LiveInfoVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Integer> ids;
	private Long userId;
	private TimeAreaVo createTime;
	private Integer type;
	private TimeAreaVo start;
	private TimeAreaVo end;
	private List<Integer> labs;
	public TimeAreaVo getCreateTime() {
		return createTime;
	}
	public void setCreateTime(TimeAreaVo createTime) {
		this.createTime = createTime;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public TimeAreaVo getStart() {
		return start;
	}
	public void setStart(TimeAreaVo start) {
		this.start = start;
	}
	public TimeAreaVo getEnd() {
		return end;
	}
	public void setEnd(TimeAreaVo end) {
		this.end = end;
	}
	public List<Integer> getLabs() {
		return labs;
	}
	public void setLabs(List<Integer> labs) {
		this.labs = labs;
		
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
	

}
