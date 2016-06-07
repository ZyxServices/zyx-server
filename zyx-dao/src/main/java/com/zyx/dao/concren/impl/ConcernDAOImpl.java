package com.zyx.dao.concren.impl;

import com.zyx.dao.BaseDaoImpl;
import com.zyx.dao.concren.ConcernDAO;
import com.zyx.entity.playground.Concern;
import org.springframework.stereotype.Repository;

/**
 * Created by XiaoWei on 2016/6/7.
 */
@Repository("concernDAO")
public class ConcernDAOImpl extends BaseDaoImpl<Concern> implements ConcernDAO {
}
