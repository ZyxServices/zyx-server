package com.zyx.entity.pg;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg
 * Create by XiaoWei on 2016/6/17
 */
public class Zan   {
    /** 主键ID **/
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Long id;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer body_id;//主题id,可以是圈子，帖子，动态，活动动态
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer body_type;//定位点赞类型
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer account_id;//点赞的人

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBody_id() {
        return body_id;
    }

    public void setBody_id(Integer body_id) {
        this.body_id = body_id;
    }

    public Integer getBody_type() {
        return body_type;
    }

    public void setBody_type(Integer body_type) {
        this.body_type = body_type;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }
}
