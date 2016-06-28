package com.zyx.entity.activity.parm;

import java.io.Serializable;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UpdateDevaluationParm
 * @package com.zyx.entity.activity
 * @update 16-6-28 上午10:59
 */
public class UpdateDevaluationParm implements Serializable{

    private Integer id;

    private Integer devaluation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDevaluation() {
        return devaluation;
    }

    public void setDevaluation(Integer devaluation) {
        this.devaluation = devaluation;
    }

    @Override
    public String toString() {
        return "UpdateDevaluationParm{" +
                "id=" + id +
                ", devaluation=" + devaluation +
                '}';
    }
}
