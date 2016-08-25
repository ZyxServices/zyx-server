package com.zyx.service.system.impl;

import java.util.List;

import com.zyx.entity.system.Devaluation;
import com.zyx.mapper.system.DevaMapper;
import com.zyx.param.system.DevaParam;
import com.zyx.service.system.DevaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zyx.service.BaseServiceImpl;

@Service("devaService")
public class DevaServiceImpl extends BaseServiceImpl<Devaluation> implements DevaService {

    @Autowired
    DevaMapper devaMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public DevaServiceImpl() {
        super(Devaluation.class);
    }

    @Override
    public int deleteDevaluation(Devaluation devaluation) {
        return devaMapper.delete(devaluation);
    }

    @Override
    public List<Devaluation> selectDevas(Integer area ,Integer model) {

        return devaMapper.queryDevas(new DevaParam(area,model));
    }
    @Override
    public List<Integer> selectModelIds(Integer area, Integer model) {
        return devaMapper.queryModelIds(new DevaParam(area,model));
    }
}