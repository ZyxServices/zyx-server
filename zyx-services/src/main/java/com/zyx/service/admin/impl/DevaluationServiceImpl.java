package com.zyx.service.admin.impl;

import java.util.List;

import com.zyx.entity.system.Devaluation;
import com.zyx.mapper.system.DevaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zyx.service.BaseServiceImpl;
import com.zyx.service.admin.DevaluationService;

@Service("devaluationService")
public class DevaluationServiceImpl extends BaseServiceImpl<Devaluation> implements DevaluationService {

    @Autowired
    DevaluationMapper devaluationMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public DevaluationServiceImpl() {
        super(DevaluationServiceImpl.class);
    }

    @Override
    public int deleteDevaluation(Devaluation devaluation) {
        return devaluationMapper.delete(devaluation);
    }

    @Override
    public List<Devaluation> queryDevaluation(Integer model) {
        return devaluationMapper.queryDevaluation(model);
    }

    @Override
    public List<Integer> queryDevaIds(Integer model) {
        return devaluationMapper.queryDevaIds(model);
    }
}
