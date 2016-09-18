package com.zyx.rpc.live.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.zyx.entity.live.dto.LiveInfoDto;
import com.zyx.param.Pager;
import com.zyx.param.live.LiveInfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zyx.constants.live.LiveConstants;
import com.zyx.entity.live.LiveInfo;
import com.zyx.rpc.live.LiveInfoFacade;
import com.zyx.service.live.LiveInfoService;
import com.zyx.vo.live.LiveInfoVo;
import com.zyx.vo.live.LiveSearchVo;

@Service("liveInfoFacade")
public class LiveInfoFacadeImpl implements LiveInfoFacade {

    @Autowired
    LiveInfoService liveInfoService;
    @Autowired
    private RedisTemplate<String, Integer> watchNumberRedis;

    @Override
    public Integer add(LiveInfo liveInfo) {
        // 修正开始时间 默认状态
        long now = System.currentTimeMillis();
        if(null != liveInfo.getStartTime() && liveInfo.getStartTime() < now){
            liveInfo.setStartTime(now );
            liveInfo.setState(1);
        }else{
            liveInfo.setState(0);
        }
        liveInfo.setDel(0);
        liveInfoService.save(liveInfo);
        watchNumberRedis.opsForValue().set(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveInfo.getId(), 0);
        return liveInfo.getId();
    }

    @Override
    public void updateNotNull(LiveInfo liveInfo) {
        if(liveInfo!=null&&liveInfo.getState()!=null){
            if(liveInfo.getState().equals(-1)){
                liveInfoService.endLiveWatcherNumber(liveInfo.getId());
            }
        }
        liveInfoService.updateNotNull(liveInfo);
    }

    @Override
    public LiveInfo getById(Integer id) {
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.setId(id);
        liveInfo.setDel(0);
        List<LiveInfo> liveInfos = liveInfoService.select(liveInfo);
        liveInfo = liveInfos != null && liveInfos.size() == 1 ? liveInfos.get(0) : null;
        if(liveInfo!=null&&liveInfo.getState()!=null&&liveInfo.getState().equals(1))
            liveInfo.setWatchNumber(liveInfoService.getLiveWatcherNumber(liveInfo.getId()));
        return  liveInfo;
    }

    @Override
    public LiveInfoVo endLive(Integer id) {
        return liveInfoService.endLive(id);
    }

    @Override
    public List<LiveInfoVo> getList(LiveInfoParam liveInfoParam) {
        List<LiveInfoVo> list = liveInfoService.selectLives(liveInfoParam);
        if(liveInfoParam.getPager()==null||liveInfoParam.getPager().getPageNum()==null||liveInfoParam.getPager().getPageSize()==null){
            liveInfoParam.setPager(new Pager(1,10));
        }
        if(null!=list&&!list.isEmpty()){
            for(LiveInfoVo vo:list){
                if(vo.getState().equals(1))
                vo.setWatchNumber(liveInfoService.getLiveWatcherNumber(vo.getId()));
            }
        }
        return list;
    }

    @Override
    public void delete(Integer id) {
        liveInfoService.logicDelete(id);
    }

    @Override
    public String getLiveUrl(Integer liveId) {
        LiveInfo liveInfo = liveInfoService.selectByKey(liveId);
        return liveInfo == null ? null : liveInfo.getVedioUrl();
    }

    @Override
    public void inOrOutLive(Integer liveId, Integer inOrOut) {
        if(inOrOut!=null){
            if (inOrOut.equals(0)){
                liveInfoService.outLiveWatcherNumber(liveId);
            }else if(inOrOut.equals(1)){
                liveInfoService.inLiveWatcherNumber(liveId);
            }
        }
    }

//    @Override
//    public Map<Integer, Integer> getLiveWatchNum(List<Integer> liveIds) {
//        Random rand = new Random(System.currentTimeMillis());
//        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
//        // TODO 获取到直播的当前观看人数
//        for (Integer liveId : liveIds) {
//            numMap.put(liveId, rand.nextInt(1000));
//        }
//        return numMap;
//    }


}
