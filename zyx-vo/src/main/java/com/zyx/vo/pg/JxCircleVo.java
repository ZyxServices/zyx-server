package com.zyx.vo.pg;

import com.zyx.entity.pg.Circle;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg.dto
 * Create by XiaoWei on 2016/8/15
 */
public class JxCircleVo extends Circle {
    private Integer sequence;
    private Integer area;
    private Integer types;
    private Integer circleItemCount;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getCircleItemCount() {
        return circleItemCount;
    }

    public void setCircleItemCount(Integer circleItemCount) {
        this.circleItemCount = circleItemCount;
    }
}
