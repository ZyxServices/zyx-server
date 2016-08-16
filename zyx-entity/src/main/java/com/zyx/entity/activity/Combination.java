package com.zyx.entity.activity;

import com.zyx.entity.BaseEntity;

import java.io.Serializable;

/**
 * Created by Rainbow on 2016/8/15.
 */
public class Combination extends BaseEntity implements Serializable {

    /**
     * 组合名称
     */
    private String name;

    /**
     * 组合封面图片
     */
    private String image;

    /**
     * 是否屏蔽
     */
    private Integer mask;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return "Combination{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", mask=" + mask +
                '}';
    }
}
