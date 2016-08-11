package com.zyx.service.pg;

import com.zyx.entity.pg.MyConcern;
import com.zyx.service.BaseService;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg
 * Create by XiaoWei on 2016/6/20
 */
public interface MyConcernService extends BaseService<MyConcern> {
    Map<String, Object> addMyConcern(Integer concernId, Integer concern_type, Integer accountId);

    Map<String, Object> findByParams(Integer concernId, Integer concernType);
}
