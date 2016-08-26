package com.zyx.service.pg;

import com.zyx.entity.pg.CircleType;
import com.zyx.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg
 * Create by XiaoWei on 2016/8/25
 */
public interface CircleTypeService extends BaseService<CircleType> {
    Map<String,Object> getList();
}
