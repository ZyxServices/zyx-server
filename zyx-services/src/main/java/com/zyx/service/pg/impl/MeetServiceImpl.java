package com.zyx.service.pg.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.Meet;
import com.zyx.entity.pg.MyConcern;
import com.zyx.mapper.pg.MeetMapper;
import com.zyx.mapper.pg.MyConcernMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.MeetService;
import com.zyx.utils.DateUtils;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static com.zyx.constants.pg.PgConstants.*;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/14
 */
@Service
public class MeetServiceImpl extends BaseServiceImpl<Meet> implements MeetService {
    public MeetServiceImpl() {
        super(Meet.class);
    }

    public static final int MODEL_CIRCLE = 4;

    @Resource
    private MeetMapper meetMapper;

    @Resource
    private MyConcernMapper myConcernMapper;

    @Override
    public Map<String, Object> addMeet(Integer circleId, Integer accountId) {
        Meet meet = new Meet();
        try {
            if (circleId == null) {
//                map.put(PgConstants.STATE, PG_ERROR_CODE_30001);
//                map.put(PgConstants.ERROR_MSG, PG_ERROR_CODE_30001_MSG);
//                return map;
                return MapUtils.buildErrorMap(PG_ERROR_CODE_30001, PG_ERROR_CODE_30001_MSG);
            }
            Optional.ofNullable(circleId).ifPresent(meet::setCircleId);
            if (accountId == null) {
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30014);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30014_MSG);
//                return map;
                return MapUtils.buildErrorMap(PG_ERROR_CODE_30014, PG_ERROR_CODE_30014_MSG);

            }
            MyConcern myConcernFind = myConcernMapper.existConcern(accountId, circleId, MODEL_CIRCLE);
            if (!Objects.equals(myConcernFind, null)) {
                Integer exist = meetMapper.existTodayMeet(accountId, circleId, DateUtils.setDateStart(0).getTime(), DateUtils.setDateEnd(0).getTime());
                if (Objects.equals(exist, 0)) {
                    Optional.ofNullable(accountId).ifPresent(meet::setAccountId);
                    meet.setCreateTime(new Date().getTime());
                    save(meet);
                    return MapUtils.buildSuccessMap(SUCCESS, PG_ERROR_CODE_33000_MSG, null);
                } else {
                    return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30028, PG_ERROR_CODE_30028_MSG);
                }
            }else{
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30041, PG_ERROR_CODE_30041_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }
}
