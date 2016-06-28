package com.zyx.vo;

import java.io.Serializable;

import com.zyx.common.page.PageParam;

public class BaseVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6076341704572702103L;
	private Boolean ifSort = false;
	private String sortProperty;
	private Boolean asc = true;
	/**
	 * 页号
	 */
	private Integer pageNo;
	/**
	 * 分页大小
	 */
	private Integer pageSize;
	/**
	 * 记录条数
	 */
	private Integer count;
	/**
	 * 分页开始行
	 */
	private Integer start;
	/**
	 * 分页结束行
	 */
	private Integer end;

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

	public Boolean getAsc() {
		return asc;
	}

	public void setAsc(Boolean asc) {
		this.asc = asc;
	}

	public Integer getStart() {
		if (pageNo != null && pageSize != null&&count!=null && (pageNo * (pageSize-1) <= count)) {
			return pageSize * (pageNo - 1);
		} else {
			return start;
		}
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		if (pageNo != null&&count!=null && pageSize != null && (pageNo * (pageSize-1) <= count)) {
			return pageNo * pageSize >count?count:(pageSize * (pageNo) );
		} else {
			return end;
		}
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
