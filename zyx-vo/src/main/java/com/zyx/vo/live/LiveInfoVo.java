package com.zyx.vo.live;

import java.util.List;

import com.zyx.vo.BaseVo;

public class LiveInfoVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Long> ids;
	private Long userId;
	private Long createTimeLower;
	private Long createTimeUpper;
	private Integer type;
	private Long startUpper;
	private Long startLower;
	private Long endUpper;
	private Long endLower;
	private List<Integer> labs;
	
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
	public List<Integer> getLabs() {
		return labs;
	}
	public void setLabs(List<Integer> labs) {
		this.labs = labs;
		
	}
	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
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
	public Long getStartUpper() {
		return startUpper;
	}
	public void setStartUpper(Long startUpper) {
		this.startUpper = startUpper;
	}
	public Long getStartLower() {
		return startLower;
	}
	public void setStartLower(Long startLower) {
		this.startLower = startLower;
	}
	public Long getEndUpper() {
		return endUpper;
	}
	public void setEndUpper(Long endUpper) {
		this.endUpper = endUpper;
	}
	public Long getEndLower() {
		return endLower;
	}
	public void setEndLower(Long endLower) {
		this.endLower = endLower;
	}
}
