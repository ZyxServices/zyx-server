package com.zyx.entity.live;

import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import com.zyx.entity.BaseEntity;

import tk.mybatis.mapper.annotation.ColumnType;


@Table(name="t_live_item_text")
public class TextLiveItem extends BaseEntity{

	
	 /**serialVersionUID TODO*/ 
	
	private static final long serialVersionUID = 5254933749194981402L;
	
	@Column
	@ColumnType(jdbcType = JdbcType.BIGINT)
	private long liveId;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)
	private String content;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)
	private String imgUrl;
	public long getLiveId() {
		return liveId;
	}
	public void setLiveId(long liveId) {
		this.liveId = liveId;
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
