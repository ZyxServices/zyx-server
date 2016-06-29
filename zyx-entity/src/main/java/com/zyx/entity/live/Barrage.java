package com.zyx.entity.live;

import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import com.zyx.entity.BaseEntity;

import tk.mybatis.mapper.annotation.ColumnType;

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
@Table(name = "t_barrage")
public class Barrage extends BaseEntity{

	
	private static final long serialVersionUID = 1L;
	
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Integer liveId;
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Integer userId;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)
	private String nickName;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)
	private String avatar;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)
	private String content;
	public Integer getLiveId() {
		return liveId;
	}
	public void setLiveId(Integer liveId) {
		this.liveId = liveId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	

}
