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
	private List<Integer> ids;
	public List<Integer> getUserIds() {
		return userIds;
	}

	public Integer del = 0;
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
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}
}
