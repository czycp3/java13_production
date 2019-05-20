package com.cskaoyan.mapper;

import com.cskaoyan.bean.TechnologyPlan;

import java.sql.SQLException;
import java.util.List;

public interface TechnologyPlanMapper {

    /**
     * 查询所有工艺计划
     * @return
     */
    List<TechnologyPlan> selectToTalTechnologyPlan();

    /**
     * 根据Id更新某个工艺计划
     * @param technologyPlan
     * @throws SQLException
     */
    void updateAllByTechnologyPlanId(TechnologyPlan technologyPlan) throws SQLException;
}
