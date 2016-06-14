package com.zyx.service.pg;

import com.zyx.entity.pg.Circle;
import com.zyx.service.BaseService;

import java.util.Date;

/**
 * Created by XiaoWei on 2016/6/13.
 */
public interface CircleService extends BaseService<Circle> {

    /**
     *
     * @param title
     * @param createId
     * @param createTime
     * @param circleMasterId
     * @param details
     * @param headImgUrl
     */
    void insertCircle(String title, Integer createId, Date createTime,Integer circleMasterId,String details,String headImgUrl);
}
