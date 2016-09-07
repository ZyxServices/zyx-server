package com.zyx.entity.pg;

import com.zyx.entity.BaseEntity;
import com.zyx.entity.activity.PageViews;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg
 * Create by XiaoWei on 2016/6/21
 */
@Table(name = "circle_item")
public class CircleItem extends BaseEntity {
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer circleId;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer createId;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String title;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String content;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer hot;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer top;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer state;//帖子状态,0为正常可以访问，-1为删除，-2为屏蔽如有业务需求，可以再加入
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String imgUrl;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String baseContent;

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
    }
}
