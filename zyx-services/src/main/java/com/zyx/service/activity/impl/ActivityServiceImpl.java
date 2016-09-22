package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.entity.activity.Combination;
import com.zyx.entity.activity.CombinedData;
import com.zyx.param.activity.QueryActivityParm;
import com.zyx.param.activity.QueryCombiationParm;
import com.zyx.param.activity.QueryHistoryParm;
import com.zyx.entity.live.LiveInfo;
import com.zyx.mapper.live.LiveInfoMapper;
import com.zyx.service.pg.ConcernService;
import com.zyx.vo.activity.ActivityVo;
import com.zyx.vo.activity.CombinedDataListVo;
import com.zyx.vo.activity.CombinedDataVo;
import com.zyx.vo.activity.MemberTemplate;
import com.zyx.mapper.activity.ActivityMapper;
import com.zyx.mapper.activity.CombinationDataMapper;
import com.zyx.mapper.activity.CombinationMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.ActivityService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private CombinationMapper combinationMapper;
    @Resource
    private CombinationDataMapper combinationDataMapper;
    @Resource
    private ConcernService concernService;
    @Resource
    LiveInfoMapper liveInfoMapper;

    public ActivityServiceImpl() {
        super(Activity.class);
    }


    @Override
    public Map<String, Object> insterActivity(Integer createId, String title, String desc, String image, Long startTime,
                                              Long endTime, Long lastTime, Integer maxPeople, Integer visible,
                                              String phone, Double price, Integer type, String address, Integer examine,
                                              String memberTemplate, Long groupId) {
        Activity activity = new Activity();
        if (createId != null && title != null && desc != null && image != null && startTime != null
                && endTime != null && type != null && price != null && address != null && phone != null && !phone.equals("")) {

            activity.setUserId(createId);
            activity.setTitle(title);
            activity.setDescContent(desc);
            activity.setImgUrls(image);

            activity.setStartTime(startTime);
            activity.setEndTime(endTime);
            activity.setLastTime(lastTime);
            activity.setMaxPeople(maxPeople == null || maxPeople == 0 ? 999999 : maxPeople);
            activity.setVisible(visible);
            activity.setPhone(phone);
            activity.setPrice(price);
            activity.setType(type);
            activity.setAddress(address);
            if (type == 0) {
                //==== 生成图文直播  并获取ID  生成图文直播访问地址====
                LiveInfo liveInfo = new LiveInfo();
                liveInfo.setCreateTime(System.currentTimeMillis());
                liveInfo.setAuth(1);
                liveInfo.setType(1);
                liveInfo.setGroupId(groupId);
                liveInfo.setStartTime(startTime);
                liveInfo.setEndTime(endTime);
                liveInfo.setUserId(createId);
                liveInfo.setTitle(title);
                liveInfo.setLab(1);
                liveInfo.setState(1);
                liveInfo.setBgmUrl(image);
                liveInfo.setDel(0);
                liveInfoMapper.insert(liveInfo);
                activity.setTargetUrl(Constants.GET_LIVE_URL + liveInfo.getId());
                //===================================================
            }
            activity.setMask(0);
            activity.setExamine(examine == null ? 0 : examine);
            if (memberTemplate != null && !memberTemplate.equals("")) {
                activity.setMemberTemplate(memberTemplate);
            }
            activity.setCreateTime(System.currentTimeMillis());
        } else {
            return Constants.MAP_PARAM_MISS;
        }
        Integer integer = mapper.insert(activity);
        if (integer > 0) {
            concernService.fromConcern(activity.getId(), Constants.DYNAMIC_ACTIVITY, activity);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "发布成功", null);
        } else {
            return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10000, "活动发布失败");
        }
    }

    @Override
    public Map<String, Object> queryActivity(QueryActivityParm parm, int api) {

        if (parm != null && parm.getPageNumber() != null && parm.getPage() != null) {
            if (parm.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            if ((parm.getStartTime() != null && parm.getEndTime() == null)
                    || (parm.getEndTime() != null && parm.getStartTime() == null)) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10009, "时间参数有误");
            }
            parm.setPage((parm.getPage() - 1) * parm.getPageNumber());
            List<ActivityVo> activities;
            if (api == 0) {
                activities = activityMapper.queryActivity(parm);
            } else {
                activities = activityMapper.queryActivityByMyList(parm);
            }

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
    public Map<String, Object> queryActivityGroupName(String name) {

        if (name != null && !name.equals("")) {
            QueryCombiationParm combiationParm = new QueryCombiationParm();
            combiationParm.setName(name);
            Combination combination = combinationMapper.queryCombiation(combiationParm);
            if (combination != null) {
                CombinedData combinedData = new CombinedData();
                combinedData.setCombinedId(combination.getId());
                List<CombinedDataVo> combinedDatas = combinationDataMapper.queryCombiationData(combinedData);

                CombinedDataListVo combinedDataListVo = new CombinedDataListVo();
                combinedDataListVo.setCombinedId(combination.getId());
                combinedDataListVo.setName(combination.getName());
                combinedDataListVo.setImage(combination.getImage());
                combinedDataListVo.setMask(combination.getMask());

                if (combinedDatas.size() > 0) {
                    combinedDatas.stream().filter(e -> e != null).forEach(s -> {
                        combinedDataListVo.getActivityVos().add(s.getActivityVo());
                    });
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", combinedDataListVo);
                } else {
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", combinedDataListVo);
                }
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10002, "查无数据");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> queryActivityHistory(QueryHistoryParm history) {
        if (history != null && history.getPageNumber() != null && history.getPageHis() != null) {
            if (history.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            history.setPageHis((history.getPageHis() - 1) * history.getPageNumber());
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
