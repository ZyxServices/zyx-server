package com.zyx.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.ibatis.type.JdbcType;

import tk.mybatis.mapper.annotation.ColumnType;

/**
 * 
 * @描述: 基础实体类，包含各实体公用属性 .
 * @作者: zhanghr
 * @版本: 1.0 .
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 主键ID **/
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Long id;

	/** 创建时间 **/
	@Column
	@ColumnType(jdbcType = JdbcType.BIGINT)
	private Long createTime;

	/** 主键ID **/
	public Long getId() {
		return id;
	}

	/** 主键ID **/
	public void setId(Long id) {
		this.id = id;
	}

	/** 创建时间 **/
	public Long getCreateTime() {
		return createTime;
	}

	/** 创建时间 **/
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
}
