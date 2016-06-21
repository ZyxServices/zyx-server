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
 * Create by XiaoWei on 2016/6/14
 */
@Table(name = "meet")
public class Meet extends BaseEntity {
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer circle_id;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer account_id;

    public Integer getCircle_id() {
        return circle_id;
    }

    public void setCircle_id(Integer circle_id) {
        this.circle_id = circle_id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }
}
