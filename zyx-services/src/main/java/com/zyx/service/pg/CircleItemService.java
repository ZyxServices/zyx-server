package com.zyx.service.pg;

import com.zyx.entity.pg.CircleItem;
import com.zyx.service.BaseService;
import com.zyx.vo.pg.CircleItemVo;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg
 * Create by XiaoWei on 2016/6/21
 */
public interface CircleItemService extends BaseService<CircleItem> {
    Map<String, Object> addCircleItem(Integer circle_id, Integer create_id, String title, String content,String img_url);

    Map<String, Object> circleItemList(Integer max, Integer circleId);

    Map<String, Object> setTop(Integer topSize, Integer circleItemId);

    Map<String, Object> topList(Integer circleId, Integer max);

    Map<String, Object> deleteCircleItemByParams(Integer createThisId, Integer circleItemId);

    Map<String, Object> lbCircleItem(Integer max);

    Map<String,Object> getOneCircleItem(Integer circleItemId);

    Map<String,Object> getTjCircleItem(Integer start,Integer pageSize);

    List<CircleItemVo> getCircleItemByIds(List<Integer> ids);
}
