package com.zyx.mapper.pg;

import com.zyx.entity.pg.CircleItem;
import com.zyx.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.pg
 * Create by XiaoWei on 2016/6/21
 */
@Repository("circleItemMapper")
public interface CircleItemMapper extends BaseMapper<CircleItem> {
    List<CircleItem> circleItemList(@Param("max") Integer max, @Param(value = "circleId") Integer circleId);

    int getCircleItemCounts(@Param(value = "circleId") Integer circleId);

    List<CircleItem> topList(@Param("circleId") Integer circleId, @Param("max") Integer max);

    CircleItem findById(@Param("circleItemId") Integer circleItemId);

    Integer delByThisUser(@Param("createThisId") Integer createThisId, @Param("circleItemId") Integer circleItemId);

}
