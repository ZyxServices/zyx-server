package com.zyx.service.pg.impl;

import java.util.*;

import com.zyx.constants.Constants;
import com.zyx.entity.pg.dto.MyConcernDto;
import com.zyx.mapper.pg.MyConcernMapper;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.MyConcern;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.MyConcernService;

import javax.annotation.Resource;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/20
 */
@Service
public class MyConcernServiceImpl extends BaseServiceImpl<MyConcern> implements MyConcernService {

    public MyConcernServiceImpl() {
        super(MyConcern.class);
    }

    @Resource
    MyConcernMapper myConcernMapper;

    @Override
    public Map<String, Object> addMyConcern(Integer concernId, Integer concern_type, Integer accountId) {
        Map<String, Object> map = new HashMap<>();
        try {
            MyConcern myConcern = new MyConcern();
            if (concernId == null) {
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30015);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30015_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30015, PgConstants.PG_ERROR_CODE_30015_MSG);

            }
            Optional.ofNullable(concernId).ifPresent(myConcern::setConcernId);
            if (concern_type == null) {
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30016);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30016_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30016, PgConstants.PG_ERROR_CODE_30016_MSG);

            }
            Optional.ofNullable(concern_type).ifPresent(myConcern::setConcernType);
            if (accountId == null) {
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30014);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30014_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30014, PgConstants.PG_ERROR_CODE_30014_MSG);

            }
            Optional.ofNullable(accountId).ifPresent(myConcern::setAccountId);
            myConcern.setCreateTime(new Date().getTime());
            MyConcern myConcernFind=myConcernMapper.existConcern(accountId, concernId, concern_type);
            if(myConcernFind!=null){
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30028, PgConstants.PG_ERROR_CODE_30028_MSG);
            }
            save(myConcern);
//            map.put(PgConstants.STATE, PgConstants.SUCCESS);
//            map.put(PgConstants.SUCCESS_MSG, PgConstants.MSG_SUCCESS);
//            return map;
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> findByParams(Integer concernId, Integer concernType) {
        if (concernId == null) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30015, PgConstants.PG_ERROR_CODE_30015_MSG);
        }
        if (concernType == null) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30016, PgConstants.PG_ERROR_CODE_30016_MSG);
        }

        return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, myConcernMapper.findByParams(concernId, concernType));
    }
}
