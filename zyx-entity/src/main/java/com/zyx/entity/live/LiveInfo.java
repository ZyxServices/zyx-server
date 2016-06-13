package com.zyx.entity.live;

import java.sql.Timestamp;

import com.zyx.entity.BaseEntity;


public class LiveInfo extends BaseEntity {

	private static final long serialVersionUID = -3026184978520410936L;
	private boolean isPublic;
	private long type;
	private Timestamp createTime;
	private Timestamp start;
	private Timestamp end;
	private long userId;
	private String title;
	private int lab;
	private String bgmUrl;
	private String vedioUrl;
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public long getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLab() {
		return lab;
	}
	public void setLab(int lab) {
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
	
	

}
