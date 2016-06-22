package com.zyx.vo;

import java.io.Serializable;

public class BaseVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6076341704572702103L;
	private Boolean ifSort=false;
	private String sortProperty;
	private Boolean asc = true; 
	private Boolean ifPage=false;
	private Integer offset;
	private Integer top;
	public Boolean getIfSort() {
		return ifSort;
	}
	public void setIfSort(Boolean ifSort) {
		this.ifSort = ifSort;
	}
	public String getSortProperty() {
		return sortProperty;
	}
	public void setSortProperty(String sortProperty) {
		this.sortProperty = sortProperty;
	}
	public Boolean getIfPage() {
		return ifPage;
	}
	public void setIfPage(Boolean ifPage) {
		this.ifPage = ifPage;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Boolean getAsc() {
		return asc;
	}
	public void setAsc(Boolean asc) {
		this.asc = asc;
	}
}
