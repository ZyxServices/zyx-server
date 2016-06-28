package com.zyx.rpc.activity.utils;

import com.zyx.constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title ActivityUtils
 * @package com.zyx.rpc.activity.utils
 * @update 16-6-28 上午11:55
 */
public class ActivityUtils {

    public static Map<String,Object> Error500(){
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.STATE, Constants.ERROR_500);
        map.put(Constants.ERROR_MSG, Constants.MSG_ERROR);
        return map;
    }
}
