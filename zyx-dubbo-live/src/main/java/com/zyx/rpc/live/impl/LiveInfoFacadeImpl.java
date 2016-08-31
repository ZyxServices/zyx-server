package com.zyx.rpc.live.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.zyx.entity.live.dto.LiveInfoDto;
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
    @Override
    public Integer add(LiveInfo liveInfo) {
        // 修正开始时间
        long now = System.currentTimeMillis();
        liveInfo.setStart(liveInfo.getStart() == null || liveInfo.getStart() < now ? now : liveInfo.getStart());
        liveInfo.setState(0);
        liveInfo.setDel(0);
        liveInfoService.save(liveInfo);
        return liveInfo.getId();
    }

    @Override
    public void updateNotNull(LiveInfo liveInfo) {
        liveInfoService.updateNotNull(liveInfo);
    }

    @Override
    public LiveInfo getById(Integer id) {
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.setId(id);
        liveInfo.setDel(0);
        List<LiveInfo> liveInfos = liveInfoService.select(liveInfo);
        return liveInfos!=null&&liveInfos.size()==1?liveInfos.get(0):null;
    }

    @Override
    public List<LiveInfoVo> getList(LiveInfoParam liveInfoParam) {
        return liveInfoService.selectLives(liveInfoParam);
    }

    @Override
    public void delete(Integer id) {
        liveInfoService.logicDelete(id);
    }

    @Override
    public List<LiveInfo> searchList(LiveSearchVo liveSearchVo) {
        return null;
    }

    @Override
    public String getLiveUrl(Integer liveId) {
        LiveInfo liveInfo = liveInfoService.selectByKey(liveId);
        return liveInfo == null ? null : liveInfo.getVedioUrl();
    }
    @Override
    public Map<Integer, Integer> getLiveWatchNum(List<Integer> liveIds) {
        Random rand = new Random(System.currentTimeMillis());
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        // TODO 获取到直播的当前观看人数
        for (Integer liveId : liveIds) {
            numMap.put(liveId, rand.nextInt(1000));
        }
        return numMap;
    }
}
