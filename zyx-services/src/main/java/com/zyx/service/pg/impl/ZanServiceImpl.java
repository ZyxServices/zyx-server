package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.entity.pg.Zan;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.ZanService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/17
 */
@Service
public class ZanServiceImpl extends BaseServiceImpl<Zan> implements ZanService {
    @Override
    public Map<String, Object> addZan(Integer body_id, Integer body_type, Integer account_id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Zan zan = new Zan();
            Optional.ofNullable(body_id).ifPresent(zan::setBody_id);
            Optional.ofNullable(body_type).ifPresent(zan::setBody_type);
            Optional.ofNullable(account_id).ifPresent(zan::setAccount_id);
            save(zan);
            map.put(Constants.STATE, Constants.SUCCESS);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.STATE, Constants.ERROR_500);
            return map;
        }
    }
}
