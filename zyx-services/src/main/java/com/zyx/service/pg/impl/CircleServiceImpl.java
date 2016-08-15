package com.zyx.service.pg.impl;

import java.util.*;

import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.pg.MyConcern;
import com.zyx.entity.pg.dto.CircleItemDto;
import com.zyx.entity.pg.dto.CircleListDto;
import com.zyx.entity.pg.dto.JxCircleDto;
import com.zyx.mapper.pg.CircleItemMapper;
import com.zyx.mapper.pg.CircleMapper;
import com.zyx.mapper.pg.MyConcernMapper;
import com.zyx.service.pg.MeetService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import com.zyx.entity.pg.Circle;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.CircleService;

import javax.annotation.Resource;

/**
 * Created by XiaoWei on 2016/6/13.
 */
@Service
public class CircleServiceImpl extends BaseServiceImpl<Circle> implements CircleService {
    @Resource
    private MeetService meetService;
    @Resource
    CircleMapper circleMapper;
    @Resource
    MyConcernMapper myConcernMapper;

    @Resource
    CircleItemMapper circleItemMapper;

    public CircleServiceImpl() {
        super(Circle.class);
    }


    @Override
    public Map<String, Object> insertCircle(String title, Integer createId, Integer circleType, String details, String headImgUrl, Integer tag) {
        try {
            Circle insertCircle = new Circle();
            if (title == null || Objects.equals(title, "")) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30006, PgConstants.PG_ERROR_CODE_30006_MSG);
            }
            Optional.ofNullable(title).ifPresent(insertCircle::setTitle);
            if (createId == null || Objects.equals(createId, "")) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30005, PgConstants.PG_ERROR_CODE_30005_MSG);
            }
            Optional.ofNullable(createId).ifPresent(insertCircle::setCreateId);
            if (circleType == null) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30025, PgConstants.PG_ERROR_CODE_30025_MSG);
            }
            Optional.ofNullable(circleType).ifPresent(insertCircle::setCircleType);
           /* if (state == null) {
                map.put(Constants.STATE, PgConstants.PG_ERROR_CODE_30011);
                map.put(Constants.ERROR_MSG, PgConstants.PG_ERROR_CODE_30011_MSG);
                return map;
            }*/
//            if (type == null) {
//                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30012, PgConstants.PG_ERROR_CODE_30012_MSG);
//
//            }
//            Optional.ofNullable(type).ifPresent(insertCircle::setType);
            if (details == null || Objects.equals(details, "")) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30010, PgConstants.PG_ERROR_CODE_30010_MSG);
            }
            Optional.ofNullable(details).ifPresent(insertCircle::setDetails);
//            if (headImgUrl == null || Objects.equals(headImgUrl, "")) {
//                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30013, PgConstants.PG_ERROR_CODE_30013_MSG);
//            }
            Optional.ofNullable(headImgUrl).ifPresent(insertCircle::setHeadImgUrl);
            if (tag == null) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30027, PgConstants.PG_ERROR_CODE_30027_MSG);
            }
            Optional.ofNullable(tag).ifPresent(insertCircle::setTag);
            insertCircle.setType(0);
            insertCircle.setCreateTime(new Date().getTime());
            insertCircle.setState(0);

            mapper.insert(insertCircle);
//            map.put(Constants.STATE, PgConstants.SUCCESS);
//            map.put(Constants.SUCCESS_MSG, PgConstants.MSG_SUCCESS);
//            return map;
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);

        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> circleMeet(Integer accountId, Integer circleId) {
        return meetService.addMeet(circleId, accountId);
    }

    @Override
    public Map<String, Object> circleList(Integer max) {
        Map<String, Object> map = new HashMap<>();
        try {
            Optional.ofNullable(max).orElse(10);
            List<Circle> list = circleMapper.circleList(max);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, list);

        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> setMaster(Integer circle_id, Integer master_id, Integer account_id) {
        if (circle_id == null) {
//            resultMap.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30001);
//            resultMap.put(Constants.MSG_ERROR, PgConstants.PG_ERROR_CODE_30001_MSG);
//            return resultMap;
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30001, PgConstants.PG_ERROR_CODE_30001_MSG);

        }
        if (master_id == null) {
//            resultMap.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30002);
//            resultMap.put(Constants.MSG_ERROR, PgConstants.PG_ERROR_CODE_30002_MSG);
//            return resultMap;
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30002, PgConstants.PG_ERROR_CODE_30002_MSG);

        }
        if (account_id == null) {
//            resultMap.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30003);
//            resultMap.put(Constants.MSG_ERROR, PgConstants.PG_ERROR_CODE_30003_MSG);
//            return resultMap;
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30003, PgConstants.PG_ERROR_CODE_30003_MSG);

        }
        Circle existCircle = circleMapper.existMaster(circle_id, master_id);
        if (existCircle != null) {
//            resultMap.put(PgConstants.STATE, PgConstants.PG_ERROR_CODE_30004);
//            resultMap.put(Constants.MSG_ERROR, PgConstants.PG_ERROR_CODE_30004_MSG);
//            return resultMap;
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30004, PgConstants.PG_ERROR_CODE_30004_MSG);

        }
        Integer result = circleMapper.setMaster(circle_id, master_id, account_id);
        if (result > 0) {
//            resultMap.put(Constants.STATE, Constants.SUCCESS);
//            resultMap.put(PgConstants.SUCCESS_MSG, PgConstants.MSG_SUCCESS);
//            return resultMap;
            return MapUtils.buildSuccessMap(Constants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
        } else {
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> delete(Integer circle_id) {
        try {
            Integer result = circleMapper.deleteCircle(circle_id);
            if (result > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
            } else {
                return PgConstants.MAP_500;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> setTop(Integer circle_id) {
        try {
            Optional.ofNullable(circle_id).orElse(-1);
            Integer result = circleMapper.setTop(circle_id);
            if (result > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
            } else {
                return PgConstants.MAP_500;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }


    @Override
    public Map<String, Object> getOne(Integer circleId, Integer accountId) {
        if (circleId == null) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30001, PgConstants.PG_ERROR_CODE_30001_MSG);
        }
        if (accountId == null) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30014, PgConstants.PG_ERROR_CODE_30014_MSG);
        }
        Map<String, Object> resultMap = new HashMap<>();
        Boolean isConcern = false;
        Integer concernCount = myConcernMapper.getCounts(4, circleId);
        Integer circleItemCount = circleItemMapper.getCircleItemCounts(circleId);
        MyConcern myConcern = myConcernMapper.existConcern(accountId, circleId, 4);
        if (myConcern != null) {
            isConcern = true;
        }
        resultMap.put("concernCount", concernCount);
        resultMap.put("circleItemCount", circleItemCount);
        resultMap.put("isConcern", isConcern);
        resultMap.put("circle", circleMapper.findById(circleId));

        return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, resultMap);
    }

    @Override
    public Map<String, Object> closeMaster(Integer circleId, Integer accountId) {
        try {
            Circle circleFind = circleMapper.findById(circleId);
            if (circleFind != null) {
                if (Objects.equals(circleFind.getCreateId(), accountId)) {
                    Integer result = circleMapper.closeMaster(circleId, accountId);
                    if (result > 0) {
                        return MapUtils.buildErrorMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_39000_MSG);
                    } else {
                        return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_35000, PgConstants.PG_ERROR_CODE_35000_MSG);
                    }
                } else {
                    return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30029, PgConstants.PG_ERROR_CODE_30029_MSG);
                }
            } else {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30031, PgConstants.PG_ERROR_CODE_30031_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_35000, PgConstants.PG_ERROR_CODE_35000_MSG);
        }

    }

    @Override
    public Map<String, Object> updateHeadImg(String headImgUrl, Integer circleId) {
        try {
            Integer result = circleMapper.updateHeadImg(headImgUrl, circleId);
            if (result > 0) {
                return MapUtils.buildErrorMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_39000_MSG);
            } else {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_35000, PgConstants.PG_ERROR_CODE_35000_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_35000, PgConstants.PG_ERROR_CODE_35000_MSG);
        }
    }

    @Override
    public Map<String, Object> setAdmins(Integer createId, String adminIds, Integer circleId) {
        try {
            Circle circleFind = circleMapper.findById(circleId);
            if (circleFind != null) {
                if (Objects.equals(circleFind.getCreateId(), createId)) {
                    Integer result = circleMapper.setAdminIds(adminIds, circleId);
                    if (result > 0) {
                        return MapUtils.buildErrorMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_39000_MSG);
                    }
                } else {
                    return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30029, PgConstants.PG_ERROR_CODE_30029_MSG);
                }
            } else {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30031, PgConstants.PG_ERROR_CODE_30031_MSG);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_35000, PgConstants.PG_ERROR_CODE_35000_MSG);
        }
    }

    @Override
    public List<CircleListDto> myCreateList(Integer createId) {
        if (createId == null) {
            return null;
        }

        return circleMapper.myCreateList(createId);
    }

    @Override
    public List<CircleListDto> myConcernList(Integer accountId) {
        if (accountId == null) {
            return null;
        }

        return circleMapper.myConcernList(accountId);
    }

    @Override
    public Map<String, Object> jxCircle(Integer max) {
        try {
            Optional.ofNullable(max).orElse(3);
            List<JxCircleDto> jxCircleDtos = circleMapper.jxCircle(3, max);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, jxCircleDtos);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

}
