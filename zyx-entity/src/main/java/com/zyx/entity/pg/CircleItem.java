package com.zyx.entity.pg;

import com.zyx.entity.BaseEntity;
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
@Table(name = "circleItem")
public class CircleItem extends BaseEntity{
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer circle_id;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer create_id;
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

    public Integer getCreate_id() {
        return create_id;
    }

    public void setCreate_id(Integer create_id) {
        this.create_id = create_id;
    }

    public Integer getCircle_id() {
        return circle_id;
    }

    public void setCircle_id(Integer circle_id) {
        this.circle_id = circle_id;
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
}
