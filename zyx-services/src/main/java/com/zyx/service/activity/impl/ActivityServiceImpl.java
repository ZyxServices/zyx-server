package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.entity.activity.parm.QueryActivityParm;
import com.zyx.entity.activity.parm.QueryHistoryParm;
import com.zyx.entity.activity.parm.UpdateDevaluationParm;
import com.zyx.entity.activity.vo.ActivityVo;
import com.zyx.entity.activity.vo.MemberTemplate;
import com.zyx.mapper.activity.ActivityMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.ActivityService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public ActivityServiceImpl() {
        super(Activity.class);
    }


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
            activity.setUserId(createId);
            activity.setTitle(title);
            activity.setDescContent(desc);
            activity.setImgUrls(image);

            activity.setStartTime(startTime);
            activity.setEndTime(endTime);
            activity.setLastTime(lastTime);

            activity.setMaxPeople(maxPeople);
            activity.setVisible(visible);
            activity.setPhone(phone);
            activity.setPrice(price == null ? 0.0 : price);
            activity.setType(type);
            activity.setAddress(address == null ? "" : address);
            activity.setExamine(examine == null ? 0 : examine);
            if (activity.getExamine() == 1) {
                if (!memberTemplate.equals("")) {
                    activity.setMemberTemplate(memberTemplate);
                } else {
                    return Constants.MAP_PARAM_MISS;
                }
            } else {
                activity.setMemberTemplate("");
            }
            activity.setActivityType(1);
            activity.setCreateTime(System.currentTimeMillis());
        } else {
            return Constants.MAP_PARAM_MISS;
        }
        Integer integer = mapper.insert(activity);
        if (integer > 0) {
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "发布成功", null);
        } else {
            return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10000, "活动发布失败");
        }
    }

    @Override
    public Map<String, Object> queryActivity(QueryActivityParm parm) {

        if (parm != null && parm.getPageNumber() != null && parm.getPage() != null) {
            if (parm.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            if ((parm.getStartTime() != null && parm.getEndTime() == null)
                    || (parm.getEndTime() != null && parm.getStartTime() == null)) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10009, "时间参数有误");
            }
            Integer pageNumber = parm.getPageNumber();
            Integer page = parm.getPage();
            if (page == 0) page = 1;
            if (page == 1) {
                parm.setPage(pageNumber == 1 ? pageNumber : pageNumber - 1);
                parm.setPageNumber(0);
            } else {
                parm.setPageNumber(pageNumber);
                parm.setPage((pageNumber * page) - 1);
            }

            List<ActivityVo> activities = activityMapper.queryActivity(parm);
            if (activities.size() > 0) {
                if (parm.getEditState() != 0) {
                    activities.stream().filter(e -> e.getDescContent() != null && !e.getDescContent().equals("")).forEach(s -> {
                        String[] strings = s.getDescContent().split("<img");
                        List<String> editImage = new ArrayList<>();
                        String editText = "";
                        for (String string : strings) {
                            if (string.contains("src=")) {
                                 editImage.add(string.substring(string.indexOf("src=\"") + 5, string.indexOf("\"/")));
                            } else {
                                if (editText.equals(string)) {
                                    editText = string;
                                } else {
                                    editText += string;
                                }

                            }
                        }
                        s.setEditDescImgUrl(editImage);
                        s.setEditDesc(editText);
                    });
                }
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", activities);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10002, "查无数据");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> queryActivityMember(Integer id) {

        Map<String, Object> map = new HashMap<>();

        if (id != null && id > 0) {
            MemberTemplate template = activityMapper.queryActivityMember(id);
            if (template != null) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", template);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10002, "查无数据");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> queryActivityHistory(QueryHistoryParm history) {
        Map<String, Object> map = new HashMap<>();

        if (history != null && history.getPageNumber() != null && history.getPageHis() != null) {
            if (history.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            Integer pageNumber = history.getPageNumber();
            Integer page = history.getPageHis();
            if (page == 0) page = 1;
            if (page == 1) {
                history.setPageHis(pageNumber == 1 ? 9 : pageNumber - 1);
                history.setPageNumber(0);
            } else {
                history.setPageNumber(pageNumber);
                history.setPageHis((pageNumber * page) - 1);
            }

            List<ActivityVo> activityHistory = activityMapper.queryActivityHistory(history);

            List<ActivityVo> activities = activityHistory
                    .stream()
                    .filter(e -> e != null && (e.getEndTime() - e.getStartTime()) <= 0)
                    .collect(Collectors.toList());

            if (activities != null && activities.size() > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", activities);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10002, "查无数据");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }
}
