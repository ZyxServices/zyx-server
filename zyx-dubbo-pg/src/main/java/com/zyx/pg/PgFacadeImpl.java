package com.zyx.pg;

import com.zyx.service.pg.CircleService;
import com.zyx.service.pg.ConcrenService;
import com.zyx.service.pg.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ConcrenService concrenService;
    @Autowired
    private MeetService meetService;

    @Override
    public Map<String, Object> addMeet(Integer circleId, Integer accountId) {
        return meetService.addMeet(circleId,accountId);
    }

    @Override
    public Map<String, Object> insertCircle(String title, Integer createId, Integer circleMasterId, String details, String headImgUrl) {
        return circleService.insertCircle(title,createId,circleMasterId,details,headImgUrl);
    }

    @Override
    public Map<String, Object> circleMeet(Integer accountId, Integer circleId) {
        return null;
    }
}
