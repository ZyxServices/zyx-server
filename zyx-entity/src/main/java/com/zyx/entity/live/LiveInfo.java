package com.zyx.entity.live;

import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import com.zyx.entity.BaseEntity;

import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "t_live")
public class LiveInfo extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Integer auth;
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Integer type;
	@Column
	@ColumnType(jdbcType = JdbcType.BIGINT)
	private Long start;
	@Column
	@ColumnType(jdbcType = JdbcType.BIGINT)
	private Long end;
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Integer userId;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)
	private String title;
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Integer lab;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)
	private String bgmUrl;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)
	private String vedioUrl;
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Integer status =0;
	public Integer getAuth() {
		return auth;
	}

	public void setAuth(Integer auth) {
		this.auth = auth;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLab() {
		return lab;
	}

	public void setLab(Integer lab) {
		this.lab = lab;
	}

	public String getBgmUrl() {
		return bgmUrl;
	}

	public void setBgmUrl(String bgmUrl) {
		this.bgmUrl = bgmUrl;
	}

	public String getVedioUrl() {
		return vedioUrl;
	}

	public void setVedioUrl(String vedioUrl) {
		this.vedioUrl = vedioUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
