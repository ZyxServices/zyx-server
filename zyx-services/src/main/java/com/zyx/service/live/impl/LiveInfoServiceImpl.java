package com.zyx.service.live.impl;

import java.util.List;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.constants.live.LiveConstants;
import com.zyx.entity.live.dto.LiveInfoDto;
import com.zyx.param.live.LiveInfoParam;
import com.zyx.service.pg.ConcernService;
import com.zyx.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zyx.entity.live.LiveInfo;
import com.zyx.mapper.live.LiveInfoMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.live.LiveInfoService;
import com.zyx.vo.live.LiveInfoVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service("liveInfoService")
public class LiveInfoServiceImpl extends BaseServiceImpl<LiveInfo> implements LiveInfoService {

    @Autowired
    LiveInfoMapper liveInfoMapper;
    @Autowired
    ConcernService concernService;
    @Autowired
    private RedisTemplate<String, Integer> watchNumberRedis;

    public LiveInfoServiceImpl() {
        super(LiveInfo.class);
    }

    @Override
    public void saveLiveInfo(LiveInfo liveInfo) {
        liveInfoMapper.saveLiveInfo(liveInfo);
        if (liveInfo != null && liveInfo.getId() != null) {
            concernService.fromConcern(liveInfo.getId(), Constants.DYNAMIC_ACTIVITY, liveInfo);
        }
    }

    @Override
    public Long countLive(LiveInfoParam param) {
        return liveInfoMapper.countLives(param);
    }

    @Override
    public List<LiveInfoVo> selectLives(LiveInfoParam param) {
        if (param.getPager() != null && param.getPager().getPageSize() != null && param.getPager().getOffset() != null) {
            param.getPager().setCount(liveInfoMapper.countLives(param));
        }
        return liveInfoMapper.selectLives(param);
    }

    @Override
    public void logicDelete(Integer id) {
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.setId(id);
        liveInfo.setDel(-1);
        updateNotNull(liveInfo);
    }

    @Override
    public LiveInfoVo endLive(Integer id) {
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.setId(id);
        liveInfo.setState(-1);
        liveInfo.setEndTime(System.currentTimeMillis());
        updateNotNull(liveInfo);
        LiveInfoVo liveInfoVo = liveInfoMapper.selectEndLiveInfo(id);
        liveInfoVo.countLiveTime();//计算直播时长
        liveInfoVo.setWatchNumber(getLiveWatcherNumber(id));
        return liveInfoMapper.selectEndLiveInfo(id);
    }
    ////////////////观看人数处理/////////////////////////////////

    /**
     * 获取直播人数
     *
     * @param liveId
     * @return
     */
    public Integer getLiveWatcherNumber(Integer liveId) {
        Integer integer = watchNumberRedis.opsForValue().get(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
        return integer == null ? 0 : integer;
    }

    public void inLiveWatcherNumber(Integer liveId) {
        Integer num = watchNumberRedis.opsForValue().get(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
        watchNumberRedis.opsForValue().set(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId, num == null ? 0 : (num + 1));
    }

    public void outLiveWatcherNumber(Integer liveId) {
        Integer num = watchNumberRedis.opsForValue().get(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
        watchNumberRedis.opsForValue().set(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId, (num == null || num < 1) ? 0 : num - 1);
    }

    public void endLiveWatcherNumber(Integer liveId) {
        Integer num = watchNumberRedis.opsForValue().get(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
        watchNumberRedis.delete(LiveConstants.MARK_LIVE_WATCH_NUMBER + liveId);
    }


}
