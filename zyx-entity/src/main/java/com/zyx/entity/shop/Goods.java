package com.zyx.entity.shop;

import javax.persistence.Column;

import org.apache.ibatis.type.JdbcType;

import com.zyx.entity.BaseEntity;

import tk.mybatis.mapper.annotation.ColumnType;

public class Goods extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Column
	@ColumnType(jdbcType = JdbcType.CHAR)
	private String title;
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Integer type;
	@Column
	@ColumnType(jdbcType = JdbcType.CHAR)
	private String descs;
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private Integer scope;
	@Column
	@ColumnType(jdbcType = JdbcType.FLOAT)
	private Float price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDesc() {
		return descs;
	}

	public void setDesc(String desc) {
		this.descs = desc;
	}

	public Integer getScope() {
		return scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [title=" + title + ", type=" + type + ", descs=" + descs + ", scope=" + scope + ", price=" + price
				+ "]";
	}

	
}
