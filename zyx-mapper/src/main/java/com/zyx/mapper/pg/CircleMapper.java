package com.zyx.mapper.pg;

import com.zyx.entity.pg.Circle;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoWei on 2016/6/13.
 */
@Repository("circleMapper")
public interface CircleMapper extends BaseMapper<Circle> {
    List<Circle> circleList(Integer max);
}
