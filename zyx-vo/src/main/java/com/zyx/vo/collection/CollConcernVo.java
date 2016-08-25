package com.zyx.vo.collection;

import com.zyx.vo.pg.MyFollowVo;

/**
 * Created by wms on 2016/8/25.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title CollConcernVo.java
 */
public class CollConcernVo extends CollectionVo {
    MyFollowVo myFollowVo;

    public MyFollowVo getMyFollowVo() {
        return myFollowVo;
    }

    public void setMyFollowVo(MyFollowVo myFollowVo) {
        this.myFollowVo = myFollowVo;
    }
}
