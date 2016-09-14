package com.zyx.entity.pg;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by XiaoWei on 2016/6/13.
 */
//圈子实体
@Table(name = "circle")
public class Circle extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String title;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer createId;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer state;//状态,可以随业务逻辑增加，但必须在此注明类型说明。0为所有可见,-1为删除,-2为屏蔽
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String adminIds;//管理员ids
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer type;//圈子类型,0未普通圈子，1位明星圈子
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer circleMasterId;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String details;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String headImgUrl;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer top;//1位置顶，其他都为不置顶
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer hot;//热度
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer tag;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer circleType;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Long groupId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCircleMasterId() {
        return circleMasterId;
    }

    public void setCircleMasterId(Integer circleMasterId) {
        this.circleMasterId = circleMasterId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getAdminIds() {
        return adminIds;
    }

    public void setAdminIds(String adminIds) {
        this.adminIds = adminIds;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getCircleType() {
        return circleType;
    }

    public void setCircleType(Integer circleType) {
        this.circleType = circleType;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
