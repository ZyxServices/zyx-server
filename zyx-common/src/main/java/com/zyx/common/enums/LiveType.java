package com.zyx.common.enums;

public enum LiveType {
	TEXT(1);

	private int type;

	LiveType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}
}
