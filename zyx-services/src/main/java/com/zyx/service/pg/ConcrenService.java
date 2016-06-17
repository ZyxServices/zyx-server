package com.zyx.service.pg;

import com.zyx.entity.pg.Concern;
import com.zyx.service.BaseService;

import java.util.Map;

/**
 * Created by XiaoWei on 2016/6/7.
 */
public interface ConcrenService extends BaseService<Concern> {
    Map<String,Object> addCern(Integer userId,String cernTitle,String content,String  cernImgurl,String videoUrl,Integer visible);
}
