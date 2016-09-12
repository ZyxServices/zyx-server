package com.zyx.service.pg.impl;

import java.util.*;

import com.zyx.vo.pg.ZanCountVo;
import com.zyx.mapper.pg.ZanMapper;
import com.zyx.utils.MapUtils;
import com.zyx.vo.pg.ZanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.Zan;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.ZanService;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/17
 */
@Service
public class ZanServiceImpl extends BaseServiceImpl<Zan> implements ZanService {
    @Autowired
    ZanMapper zanMapper;

    public ZanServiceImpl() {
        super(Zan.class);
    }

    @Override
    public Map<String, Object> addZan(Integer body_id, Integer body_type, Integer account_id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Zan zan = new Zan();
            if (body_id == null) {
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30009);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30009_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30009, PgConstants.PG_ERROR_CODE_30009_MSG);

            }
            Optional.ofNullable(body_id).ifPresent(zan::setBodyId);
            if (body_type == null) {
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30017);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30017_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30017, PgConstants.PG_ERROR_CODE_30017_MSG);

            }
            Optional.ofNullable(body_type).ifPresent(zan::setBodyType);
            if (account_id == null) {
//                map.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30014);
//                map.put(PgConstants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30014_MSG);
//                return map;
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30014, PgConstants.PG_ERROR_CODE_30014_MSG);

            }
            Optional.ofNullable(account_id).ifPresent(zan::setAccountId);
            Integer result = zanMapper.exist(body_id, body_type, account_id);
            if (Objects.equals(result, 0)) {
                save(zan);
                return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
            } else {
                Integer deleteResult = zanMapper.cancelZan(body_id, body_type, account_id);
                if (deleteResult > 0)
                    return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_30040_MSG, null);
                else
                    return PgConstants.MAP_500;
            }
//            map.put(PgConstants.STATE, PgConstants.SUCCESS);
//            map.put(PgConstants.SUCCESS_MSG, PgConstants.MSG_SUCCESS);
//            return map;


        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public List<ZanCountVo> countZanByBodyId(Integer type, List<Integer> bodyIds) {
        ZanVo vo = new ZanVo();
        vo.setType(type);
        vo.setBodyIds(bodyIds);
        return zanMapper.countZanByBodyId(vo);
    }

    @Override
    public ZanCountVo countZanByBodyId(Integer type, Integer bodyId) {
        Zan record = new Zan();
        record.setBodyType(type);
        record.setBodyId(bodyId);
        ZanCountVo dto = new ZanCountVo();
        dto.setBodyId(bodyId);
        dto.setBodyType(type);
        dto.setZanCount(selectCount(record));
        return dto;
    }
}
