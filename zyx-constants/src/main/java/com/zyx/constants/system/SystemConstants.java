package com.zyx.constants.system;

import com.zyx.constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MrDeng on 2016/8/3.
 */
public interface SystemConstants extends Constants {
    public static String MAKE_REDIS_DEVA = "deva:";
    public static String MAKE_REDIS_INNER_DEVA = "inner_deva:";
    public static String MAKE_REDIS_INNER_DEVA_ID = "inner_deva_id:";

    int DEVA_NOT_EXIST_MODEL_AREA = 73001;
    String MSG_DEVA_NOT_EXIST_MODEL_AREA = "not exist modle or area ";

    Map<String, Integer> DEVA_AREA_MAX_ITEM = new HashMap<String, Integer>() {
        {
            put("1_1", 5);
            put("2_1",12);
            put("4_1",3);
            put("5_1",9);
            put("6_1",10);
            put("4_3",5);
            put("3_3",3);
            put("2_2",4);
        }
    };
}
