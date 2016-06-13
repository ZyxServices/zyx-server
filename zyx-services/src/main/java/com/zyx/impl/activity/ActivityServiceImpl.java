package com.zyx.impl.activity;

import com.zyx.constants.AuthConstants;
import com.zyx.constants.activity.AuthActivityConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.ActivityService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
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



    @Override
    public Map<String, Object> insterActivity(String title, String desc, String image, String startTime, String endTime,
                                              String lastTime, String maxPeople, String visible, String phone, String price,
                                              String type, String address, String examine, String memberTemplate) {
        Activity activity = new Activity();
        Map<String, Object> map = new HashMap<String, Object>();

        if (title != null && desc != null && image != null && startTime != null
                && endTime != null && lastTime != null && maxPeople != null
                && visible != null && phone != null && type != null && address != null
                && examine != null && memberTemplate != null) {

            activity.setTitle(title);
            activity.setDesc(desc);
            activity.setImgUrls(image);

            try {
                activity.setStartTime(AuthActivityConstants.SDF.parse(startTime));
                activity.setEndTime(AuthActivityConstants.SDF.parse(endTime));
                activity.setLastTime(AuthActivityConstants.SDF.parse(lastTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            activity.setMaxPeople(Integer.valueOf(maxPeople));
            activity.setVisible(Integer.valueOf(visible));
            activity.setPhone(phone);
            activity.setPrice(price == null ? 0.0 : Double.valueOf(price));
            activity.setType(Integer.valueOf(type));
            activity.setAddress(address);
            activity.setExamine(Integer.valueOf(examine));
            if (!memberTemplate.equals("")) {
                activity.setMemberTemplate(memberTemplate);
            } else {
                map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_100);
                map.put(AuthConstants.AUTH_ERRORMSG, "参数缺失");
                return map;
            }
        } else {
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_100);
            map.put(AuthConstants.AUTH_ERRORMSG, "参数缺失");
            return map;
        }
        long integer = 1;/*releaseDao.insert(activity);*/
        if (integer > 0) {
            map.put(AuthConstants.AUTH_STATE, AuthConstants.AUTH_SUCCESS_200);
            map.put(AuthConstants.AUTH_SUCCESS, "发布成功");
            return map;
        }else{
            map.put(AuthConstants.AUTH_STATE,AuthActivityConstants.AUTH_SUCCESS_10000);
            map.put(AuthConstants.AUTH_ERRORMSG,"活动发布失败");
            return map;
        }
    }
}
