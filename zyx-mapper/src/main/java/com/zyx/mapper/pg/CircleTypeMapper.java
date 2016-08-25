package com.zyx.mapper.pg;

import com.zyx.entity.pg.CircleType;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.pg
 * Create by XiaoWei on 2016/8/25
 */

@Repository("circleTypeMapper")
public interface CircleTypeMapper extends BaseMapper<CircleType> {
    List<CircleType> getList();
}
