package com.zyx.service.pg.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.zyx.constants.Constants;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.MyConcern;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.MyConcernService;

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
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30015);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30015_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30015 ,PgConstants.PG_ERROR_CODE_30015_MSG);

            }
            Optional.ofNullable(concernId).ifPresent(myConcern::setConcern_id);
            if (concern_type == null) {
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30016);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30016_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30016 ,PgConstants.PG_ERROR_CODE_30016_MSG);

            }
            Optional.ofNullable(concern_type).ifPresent(myConcern::setConcern_type);
            if (accountId == null) {
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30014);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30014_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30014 ,PgConstants.PG_ERROR_CODE_30014_MSG);

            }
            Optional.ofNullable(accountId).ifPresent(myConcern::setAccount_id);
            myConcern.setCreateTime(new Date().getTime());
            save(myConcern);
//            map.put(PgConstants.STATE, PgConstants.SUCCESS);
//            map.put(PgConstants.SUCCESS_MSG, PgConstants.MSG_SUCCESS);
//            return map;
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS ,PgConstants.PG_ERROR_CODE_33000_MSG,null);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }
}
