package com.zyx.entity.live;

import java.sql.Timestamp;

import com.zyx.entity.BaseEntity;

public class TextLiveItem extends BaseEntity{

	
	 /**serialVersionUID TODO*/ 
	
	private static final long serialVersionUID = 5254933749194981402L;
	
	private long lvieId;
	private Timestamp createTime;
	private String content;
	private String imgUrl;
	public long getLvieId() {
		return lvieId;
	}
	public void setLvieId(long lvieId) {
		this.lvieId = lvieId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	

}
