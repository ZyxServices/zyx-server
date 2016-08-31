package com.zyx.rpc.pg;

import com.zyx.vo.pg.ZanCountVo;
import com.zyx.service.pg.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.pg
 * Create by XiaoWei on 2016/6/14
 */
@Service("pgFacade")
public class PgFacadeImpl implements PgFacade {
    @Autowired
    private CircleService circleService;
    @Autowired
    private ConcernService concrenService;
    @Autowired
    private MeetService meetService;
    @Autowired
    private ZanService zanService;
    @Autowired
    private MyConcernService myConcernService;
    @Autowired
    private CircleItemService circleItemService;
    @Autowired
    private CircleTypeService circleTypeService;

    @Override
    public Map<String, Object> addMeet(Integer circleId, Integer accountId) {
        return meetService.addMeet(circleId, accountId);
    }

    @Override
    public Map<String, Object> insertCircle(String title, Integer createId, Integer circleType, String details, String headImgUrl, Integer tag) {
        return circleService.insertCircle(title, createId, circleType, details, headImgUrl, tag);
    }

    @Override
    public Map<String, Object> addCern(Integer userId, Integer type, String cernTitle, String content, String cernImgurl, String videoUrl, Integer visible) {
        return concrenService.addCern(userId, type, cernTitle, content, cernImgurl, videoUrl, visible);
    }

    @Override
    public Map<String, Object> addZan(Integer body_id, Integer body_type, Integer account_id) {
        return zanService.addZan(body_id, body_type, account_id);
    }

    @Override
    public Map<String, Object> addMyConcern(Integer concernId, Integer concern_type, Integer accountId) {
        return myConcernService.addMyConcern(concernId, concern_type, accountId);
    }

    @Override
    public Map<String, Object> circleList(Integer max) {
        return circleService.circleList(max);
    }

    @Override
    public Map<String, Object> starRandom(Integer type, Integer n) {
        return concrenService.starRandom(type, n);
    }

    @Override
    public Map<String, Object> addCircleItem(Integer circle_id, Integer create_id, String title, String content, String img_url) {
        return circleItemService.addCircleItem(circle_id, create_id, title, content, img_url);
    }

    @Override
    public Map<String, Object> setMaster(Integer circle_id, Integer master_id, Integer account_id) {
        return circleService.setMaster(circle_id, master_id, account_id);
    }

    @Override
    public Map<String, Object> delete(Integer circle_id) {
        return circleService.delete(circle_id);
    }

    @Override
    public Map<String, Object> circleItemList(Integer max, Integer circleId) {
        return circleItemService.circleItemList(max, circleId);
    }

    @Override
    public Map<String, Object> setTop(Integer tooSize, Integer circleItemId) {
        return circleItemService.setTop(tooSize, circleItemId);
    }

    @Override
    public Map<String, Object> top(Integer max, Integer circleId) {
        return circleItemService.topList(circleId, max);
    }

    @Override
    public Map<String, Object> delCern(Integer id, Integer loginUserId) {
        return concrenService.delCern(id, loginUserId);
    }


    @Override
    public List<ZanCountVo> countZanByBodyId(Integer type, List<Integer> bodyIds) {
        return zanService.countZanByBodyId(type, bodyIds);
    }

    @Override
    public ZanCountVo countZanByBodyId(Integer type, Integer bodyId) {
        return zanService.countZanByBodyId(type, bodyId);
    }

    @Override
    public Map<String, Object> findCircle(Integer circleId, Integer accountId) {
        return circleService.getOne(circleId, accountId);
    }

    @Override
    public Map<String, Object> findMyConcernParams(Integer concernId, Integer concernType) {
        return myConcernService.findByParams(concernId, concernType);
    }

    @Override
    public Map<String, Object> deleteCircleItem(Integer createThisId, Integer circleItemId) {
        return circleItemService.deleteCircleItemByParams(createThisId, circleItemId);
    }

    @Override
    public Map<String, Object> closeMaster(Integer circleId, Integer accountId) {
        return circleService.closeMaster(circleId, accountId);
    }

    @Override
    public Map<String, Object> updateCircleImg(String imgUrl, Integer circleId) {
        return circleService.updateHeadImg(imgUrl, circleId);
    }

    @Override
    public Map<String, Object> setAdmins(Integer createId, String adminIds, Integer circleId) {
        return circleService.setAdmins(createId, adminIds, circleId);
    }

    @Override
    public Map<String, Object> jxCircle(Integer max) {
        return circleService.jxCircle(max);
    }

    @Override
    public Map<String, Object> lbCircleItem(Integer max) {
        return circleItemService.lbCircleItem(max);
    }

    @Override
    public Map<String, Object> getMyFollowList(Integer loginUserId) {
        return concrenService.getMyFollowList(loginUserId);
    }

    @Override
    public Map<String, Object> starConcern(Integer max) {
        return concrenService.starConcern(max);
    }

    @Override
    public Map<String, Object> getOneConcern(Integer concernId) {
        return concrenService.getOne(concernId);
    }

    @Override
    public Map<String, Object> getOneCircleItem(Integer circleItemId) {
        return circleItemService.getOneCircleItem(circleItemId);
    }

    @Override
    public Map<String, Object> getTjCircleItem(Integer start, Integer pageSize) {
        return circleItemService.getTjCircleItem(start, pageSize);
    }

    @Override
    public Map<String, Object> getCircleTypeList() {
        return circleTypeService.getList();
    }

    @Override
    public Map<String, Object> delMyConcern(Integer circleId, Integer accountId) {
        return myConcernService.delMyConcern(circleId, accountId);
    }

}
