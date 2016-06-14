package com.zyx.entity.live;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import com.zyx.entity.BaseEntity;

import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "t_live")
public class LiveInfo extends BaseEntity {

	private static final long serialVersionUID = -3026184978520410936L;
	@Column
	@ColumnType(jdbcType = JdbcType.BOOLEAN)
	private boolean isPublic;
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private int type;
	@Column
	@ColumnType(jdbcType = JdbcType.TIMESTAMP)
	private Timestamp start;
	@Column
	@ColumnType(jdbcType = JdbcType.TIMESTAMP)
	private Timestamp end;
	@Column
	@ColumnType(jdbcType = JdbcType.BIGINT)
	private long userId;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)
	private String title;
	@Column
	@ColumnType(jdbcType = JdbcType.INTEGER)
	private int lab;
	@Column
	@ColumnType(jdbcType = JdbcType.VARCHAR)

	private String bgmUrl;

	private String vedioUrl;

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public void setUserId(long userId) {
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
