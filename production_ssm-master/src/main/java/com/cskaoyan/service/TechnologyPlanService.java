package com.cskaoyan.service;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanService {

    /**
     * 查询所有工艺计划
     * @return
     */
    List<TechnologyPlan> selectByExample();

    /**
     * 根据Id更新工艺计划
     * @param technologyPlan
     * @return
     */
    QueryStatus updateAll(TechnologyPlan technologyPlan);
}
