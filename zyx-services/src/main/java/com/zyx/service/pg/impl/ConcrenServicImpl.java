package com.zyx.service.pg.impl;


import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import org.springframework.stereotype.Service;

import com.zyx.entity.pg.Concern;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.ConcrenService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by XiaoWei on 2016/6/7.
 */
@Service
public class ConcrenServicImpl extends BaseServiceImpl<Concern> implements ConcrenService {

    @Override
    public Map<String,Object> addCern(Integer userId,Integer type,String cernTitle,String content,String  cernImgurl,String videoUrl,Integer visible) {
        Map<String, Object> map = new HashMap<>();
        try {
            Concern insertCern = new Concern();
            insertCern.setCreateTime(new Date().getTime());
            Optional.ofNullable(userId).ifPresent(insertCern::setUser_id);
            Optional.ofNullable(type).ifPresent(insertCern::setType);
            Optional.ofNullable(cernTitle).ifPresent(insertCern::setTopic_title);
            Optional.ofNullable(content).ifPresent(insertCern::setTopic_content);
            Optional.ofNullable(cernImgurl).ifPresent(insertCern::setImg_url);
            Optional.ofNullable(videoUrl).ifPresent(insertCern::setVideo_url);
            Optional.ofNullable(visible).ifPresent(insertCern::setTopic_visible);
            save(insertCern);
            map.put(Constants.STATE, Constants.SUCCESS);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.STATE, Constants.ERROR_500);
            return map;
        }
    }
}
