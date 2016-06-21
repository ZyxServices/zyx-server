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
    private Integer concern_id;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer concern_type;//关注类型，1为明星，2为个人，3为球队
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer account_id;

    public Integer getConcern_id() {
        return concern_id;
    }

    public void setConcern_id(Integer concern_id) {
        this.concern_id = concern_id;
    }

    public Integer getConcern_type() {
        return concern_type;
    }

    public void setConcern_type(Integer concern_type) {
        this.concern_type = concern_type;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }
}
