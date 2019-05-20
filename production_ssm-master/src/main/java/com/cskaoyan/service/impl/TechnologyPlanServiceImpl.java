package com.cskaoyan.service.impl;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.controller.TechnologyPlanController;
import com.cskaoyan.mapper.TechnologyPlanMapper;
import com.cskaoyan.service.TechnologyPlanService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    private TechnologyPlanMapper technologyPlanMapper;

    public TechnologyPlanServiceImpl(TechnologyPlanMapper technologyPlanMapper) {
        this.technologyPlanMapper = technologyPlanMapper;
    }

    @Override
    public List<TechnologyPlan> selectByExample() {
        return technologyPlanMapper.selectToTalTechnologyPlan();
    }

    @Override
    public QueryStatus updateAll(TechnologyPlan technologyPlan) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            technologyPlanMapper.updateAllByTechnologyPlanId(technologyPlan);
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        } catch (SQLException e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重新操作！");
        }
        return queryStatus;
    }
}
