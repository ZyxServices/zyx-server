package com.zyx.service.pg.impl;

import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.CircleType;
import com.zyx.mapper.pg.CircleTypeMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.CircleTypeService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/8/25
 */
@Service
public class CircleTypeServiceImpl extends BaseServiceImpl<CircleType> implements CircleTypeService {
    public CircleTypeServiceImpl() {
        super(CircleType.class);
    }

    @Resource
    private CircleTypeMapper circleTypeMapper;

    @Override
    public Map<String, Object> getList() {
        try {
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, circleTypeMapper.getList());
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }
}
