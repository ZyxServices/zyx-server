package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
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
            if (body_id == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30009);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30009_MSG);
                return map;
            }
            Optional.ofNullable(body_id).ifPresent(zan::setBody_id);
            if (body_type == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30017);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30017_MSG);
                return map;
            }
            Optional.ofNullable(body_type).ifPresent(zan::setBody_type);
            if (account_id == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30014);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30014_MSG);
                return map;
            }
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
