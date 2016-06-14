package com.zyx.entity.pg;

import com.zyx.entity.BaseEntity;

import javax.persistence.Table;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg
 * Create by XiaoWei on 2016/6/14
 */
@Table(name = "meet")
public class Meet extends BaseEntity {
    private Integer circleId;
    private Integer accountId;

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
