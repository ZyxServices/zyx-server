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
 * Create by XiaoWei on 2016/6/20
 */
//我的关注
@Table(name = "myconcern")
public class MyConcern  extends BaseEntity{
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer concernId;//关注类型id
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer concernType;//关注类型，0为动态，1为明星，2为个人，3为球队,4为圈子，5为活动，6位直播
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer accountId;

    public Integer getConcernId() {
        return concernId;
    }

    public void setConcernId(Integer concernId) {
        this.concernId = concernId;
    }

    public Integer getConcernType() {
        return concernType;
    }

    public void setConcernType(Integer concernType) {
        this.concernType = concernType;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
