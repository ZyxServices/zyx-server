package com.zyx.concren.impl;

import com.zyx.concren.ConcrenInfoService;
import com.zyx.entity.playground.Concern;
import com.zyx.mapper.service.ConcrenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by XiaoWei on 2016/6/7.
 */
@Service
public class ConcrenInfoServiceImpl implements ConcrenInfoService {

    @Resource
    private ConcrenService concrenService;

    @Override
    public void Add(Concern concern) {
        concrenService.save(concern);
    }
}
