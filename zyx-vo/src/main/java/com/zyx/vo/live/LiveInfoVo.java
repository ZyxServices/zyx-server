package com.zyx.vo.live;

import java.util.List;

import com.zyx.vo.BaseVo;

public class LiveInfoVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> userIds;
	private Integer auth;
	private Integer type;
	private Integer lab;
	public List<Integer> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getLab() {
		return lab;
	}
	public void setLab(Integer lab) {
		this.lab = lab;
	}
	public Integer getAuth() {
		return auth;
	}
	public void setAuth(Integer auth) {
		this.auth = auth;
	}
}
