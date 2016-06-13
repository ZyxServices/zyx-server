package com.zyx.service.activity.impl;

import com.zyx.constants.AuthConstants;
import com.zyx.constants.activity.AuthActivityConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.entity.activity.parm.QueryActivityParm;
import com.zyx.mapper.activity.ActivityMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rainbow on 16-6-12.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.service.activity.impl
 */
@Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity> implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;


    @Override
    public Map<String, Object> insterActivity(Integer createId, String title, String desc, String image, Long startTime,
                                              Long endTime, Long lastTime, Integer maxPeople, Integer visible,
                                              String phone, Double price, Integer type, String address, Integer examine,
                                              String memberTemplate) {
        Activity activity = new Activity();
        Map<String, Object> map = new HashMap<String, Object>();

        if (createId != null && title != null && desc != null && image != null && startTime != null
                && endTime != null && lastTime != null && maxPeople != null
                && visible != null && phone != null && type != null) {
            activity.setCreate_id(createId);
            activity.setTitle(title);
            activity.setDesc_content(desc);
            activity.setImg_urls(image);

            activity.setStart_time(new Date(startTime * 1000));
            activity.setEnd_time(new Date(endTime * 1000));
            activity.setLast_time(new Date(lastTime * 1000));

            activity.setMax_people(maxPeople);
            activity.setVisible(visible);
            activity.setPhone(phone);
            activity.setPrice(price == null ? 0.0 : price);
            activity.setType(type);
            activity.setAddress(address == null ? "" : address);
            activity.setExamine(examine == null ? 0 : examine);
            if (activity.getExamine() == 1) {
                if (!memberTemplate.equals("")) {
                    activity.setMember_template(memberTemplate);
                } else {
                    map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_100);
                    map.put(AuthConstants.AUTH_ERRORMSG, "参数缺失");
                    return map;
                }
            } else {
                activity.setMember_template("");
            }
            activity.setActivity_type(1);
            activity.setCreateTime(Timestamp.valueOf(new Date().toString()));
        } else {
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_100);
            map.put(AuthConstants.AUTH_ERRORMSG, "参数缺失");
            return map;
        }
        Integer integer = mapper.insert(activity);
        if (integer > 0) {
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
            map.put(AuthConstants.AUTH_SUCCESS, "发布成功");
            return map;
        } else {
            map.put(AuthConstants.AUTH_STATE, AuthActivityConstants.AUTH_SUCCESS_10000);
            map.put(AuthConstants.AUTH_ERRORMSG, "活动发布失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> queryActivity(QueryActivityParm parm) {

        Map<String, Object> map = new HashMap<String, Object>();
        if(parm != null && parm.getPageNumber() != null && parm.getPage() != null){
            List<Activity> activities = activityMapper.queryActivity(parm);

            if(activities.size() > 0){
                map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
                map.put(AuthConstants.AUTH_SUCCESS, activities);
                return map;
            }else{
                map.put(AuthConstants.AUTH_STATE, AuthActivityConstants.AUTH_SUCCESS_10002);
                map.put(AuthConstants.AUTH_ERRORMSG, "查无数据");
                return map;
            }
        }else{
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_100);
            map.put(AuthConstants.AUTH_ERRORMSG, "参数缺失");
            return map;
        }
    }
}
