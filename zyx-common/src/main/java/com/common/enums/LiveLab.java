package com.common.enums;

public enum LiveLab {

	NBA(1);
	
	private int lab;
	LiveLab(int lab){
		this.lab=lab;
	}
	public int getTab(){
		return this.lab;
	}
}
