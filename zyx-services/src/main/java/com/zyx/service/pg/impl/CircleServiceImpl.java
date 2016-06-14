package com.zyx.service.pg.impl;

import com.zyx.entity.pg.Circle;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by XiaoWei on 2016/6/13.
 */
@Service("circleService")
public class CircleServiceImpl extends BaseServiceImpl<Circle> implements CircleService {
    @Override
    public void insertCircle(String title, Integer createId, Date createTime, Integer circleMasterId, String details, String headImgUrl) {
        Circle insertCircle = new Circle();
        insertCircle.setTitle(title);
        insertCircle.setDetails(details);
        insertCircle.setCreateId(createId);
        save(insertCircle);
    }
}
