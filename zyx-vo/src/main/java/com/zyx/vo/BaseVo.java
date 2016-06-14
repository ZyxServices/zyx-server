package com.zyx.vo;

import java.io.Serializable;

public class BaseVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6076341704572702103L;
	private boolean ifSort=false;
	private boolean sortCol;
	
	private boolean ifPage=false;

	public boolean isIfSort() {
		return ifSort;
	}

	public void setIfSort(boolean ifSort) {
		this.ifSort = ifSort;
	}

	public boolean isSortCol() {
		return sortCol;
	}

	public void setSortCol(boolean sortCol) {
		this.sortCol = sortCol;
	}

	public boolean isIfPage() {
		return ifPage;
	}

	public void setIfPage(boolean ifPage) {
		this.ifPage = ifPage;
	}
	
	
}
