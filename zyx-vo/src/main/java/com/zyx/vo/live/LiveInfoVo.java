package com.zyx.vo.live;

import java.io.Serializable;
import java.util.List;

import com.zyx.vo.BaseVo;
import com.zyx.vo.account.UserIconVo;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;

public class LiveInfoVo implements Serializable {
	private Integer id;
	private Integer auth;
	private Integer type;
	private Long start;
	private Long end;
	private UserIconVo userIconVo;
	private String title;
	private Integer lab;
	private String bgmUrl;
	private Long groupId;
	private String vedioUrl;
	private Integer state;
	// 用户认证标签
	private String authInfo;

	/**
	 * 当前直播的点赞数量
	 */
	private Integer zanCount;

	/**
	 * 当前直播消息数量
	 */
	private Integer msgCount;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAuth(Integer auth) {
		this.auth = auth;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	public void setUserIconVo(UserIconVo userIconVo) {
		this.userIconVo = userIconVo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLab(Integer lab) {
		this.lab = lab;
	}

	public void setBgmUrl(String bgmUrl) {
		this.bgmUrl = bgmUrl;
	}

	public void setVedioUrl(String vedioUrl) {
		this.vedioUrl = vedioUrl;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public Integer getAuth() {
		return auth;
	}

	public Integer getType() {
		return type;
	}

	public Long getStart() {
		return start;
	}

	public Long getEnd() {
		return end;
	}

	public UserIconVo getUserIconVo() {
		return userIconVo;
	}

	public String getTitle() {
		return title;
	}

	public Integer getLab() {
		return lab;
	}

	public String getBgmUrl() {
		return bgmUrl;
	}

	public String getVedioUrl() {
		return vedioUrl;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Integer getState() {
		return state;
	}

	public String getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(String authInfo) {
		this.authInfo = authInfo;
	}

	public Integer getZanCount() {
		return zanCount;
	}

	public void setZanCount(Integer zanCount) {
		this.zanCount = zanCount;
	}

	public Integer getMsgCount() {
		return msgCount;
	}

	public void setMsgCount(Integer msgCount) {
		this.msgCount = msgCount;
	}
}
