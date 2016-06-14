package com.zyx.service.pg;

import com.zyx.entity.pg.Meet;
import com.zyx.service.BaseService;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg
 * Create by XiaoWei on 2016/6/14
 */
public interface MeetService  extends BaseService<Meet> {
    Map<String,Object> addMeet(Integer  circleId,Integer accountId);
}
