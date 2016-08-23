package com.zyx.param.system;

/**
 * Created by MrDeng on 2016/8/19.
 */
public class DevaParam {
    private Integer area;
    private Integer model;

    public DevaParam(Integer area, Integer model) {
        this.area = area;
        this.model = model;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }
}
