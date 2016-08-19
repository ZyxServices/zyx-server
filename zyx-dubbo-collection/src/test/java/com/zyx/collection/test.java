package com.zyx.collection;

import com.alibaba.fastjson.JSON;
import com.zyx.entity.live.LiveInfo;

/**
 * Created by MrDeng on 2016/8/18.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new LiveInfo()));
    }
}
