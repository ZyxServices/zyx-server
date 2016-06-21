package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.entity.pg.MyConcern;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.MyConcernService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/20
 */
@Service
public class MyConcernServiceImpl extends BaseServiceImpl<MyConcern> implements MyConcernService {

    @Override
    public Map<String, Object> addMyConcern(Integer concernId, Integer concern_type,Integer accountId) {
        Map<String, Object> map = new HashMap<>();
        try {
            MyConcern myConcern = new MyConcern();
            Optional.ofNullable(concernId).ifPresent(myConcern::setConcern_id);
            Optional.ofNullable(concern_type).ifPresent(myConcern::setConcern_type);
            Optional.ofNullable(accountId).ifPresent(myConcern::setAccount_id);
            myConcern.setCreateTime(new Date().getTime());
            save(myConcern);
            map.put(Constants.STATE, Constants.SUCCESS);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.STATE, Constants.ERROR_500);
            return map;
        }
    }
}
