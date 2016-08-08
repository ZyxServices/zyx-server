package com.zyx.mapper.live;

import com.zyx.entity.live.LiveLab;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("liveLabMapper")
public interface LiveLabMapper extends BaseMapper<LiveLab> {
    public List<String >getAllLabs();
}
