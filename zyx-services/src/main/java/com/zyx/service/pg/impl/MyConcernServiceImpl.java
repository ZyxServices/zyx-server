package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
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
    public Map<String, Object> addMyConcern(Integer concernId, Integer concern_type, Integer accountId) {
        Map<String, Object> map = new HashMap<>();
        try {
            MyConcern myConcern = new MyConcern();
            if (concernId == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30015);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30015_MSG);
                return map;
            }
            Optional.ofNullable(concernId).ifPresent(myConcern::setConcern_id);
            if (concern_type == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30016);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30016_MSG);
                return map;
            }
            Optional.ofNullable(concern_type).ifPresent(myConcern::setConcern_type);
            if (accountId == null) {
                map.put(Constants.ERROR_CODE, PgConstants.PG_ERROR_CODE_30014);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30014_MSG);
                return map;
            }
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
