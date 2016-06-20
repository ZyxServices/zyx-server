package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.entity.pg.Meet;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.MeetService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/14
 */
@Service
public class MeetServiceImpl extends BaseServiceImpl<Meet> implements MeetService {
    @Override
    public Map<String, Object> addMeet(Integer circleId, Integer accountId) {
        Meet meet = new Meet();
        Map<String, Object> map = new HashMap<>();
        try {
            Optional.ofNullable(circleId).ifPresent(meet::setCircle_id);
            Optional.ofNullable(accountId).ifPresent(meet::setAccount_id);
            meet.setCreateTime(new Date().getTime());
            save(meet);
            map.put(Constants.STATE, Constants.SUCCESS);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.STATE, Constants.ERROR_500);
            return map;
        }
    }
}
