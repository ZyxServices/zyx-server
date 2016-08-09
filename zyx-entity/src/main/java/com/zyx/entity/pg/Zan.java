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
    private Integer bodyId;//主题id,可以是圈子，动态，活动,直播
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer bodyType;//定位点赞类型,1:圈子，2：动态，3：活动，4：直播，5：帖子
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer accountId;//点赞的人

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public Integer getBodyType() {
        return bodyType;
    }

    public void setBodyType(Integer bodyType) {
        this.bodyType = bodyType;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
