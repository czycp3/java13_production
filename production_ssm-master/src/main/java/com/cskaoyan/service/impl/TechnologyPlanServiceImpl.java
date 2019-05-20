package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.controller.TechnologyPlanController;
import com.cskaoyan.exception.TechnologyException;
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

    @Override
    public List<TechnologyPlan> selectAllTechnologyPlan(int page, int rows) {
        int offset = (page - 1) * rows;
        return technologyPlanMapper.selectAllTechnologyPlan(rows,offset);
    }

    @Override
    public int selectCountTechnologyPlan() {
        return technologyPlanMapper.selectCountTechnologyPlan();
    }

    @Override
    public QueryStatus insert(TechnologyPlan technologyPlan) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            technologyPlanMapper.insert(technologyPlan);
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("该工艺编号已存在，请更换编号！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus deleteBatch(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                technologyPlanMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public BaseResultVo searchTechnologyPlanByTechnologyPlanId(String searchValue, int page, int rows) {
        BaseResultVo<TechnologyPlan> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        TechnologyPlan technologyPlan = new TechnologyPlan();
        technologyPlan.setTechnologyPlanId("%" + searchValue +"%");
        int total = technologyPlanMapper.selectCountTechnologyPlanByCondition(technologyPlan);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.searchTechnologyPlanByCondition(technologyPlan, rows, offset);
        //封装list和total
        baseResultVo.setRows(technologyPlans);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchTechnologyPlanbyTechnologyName(String searchValue, int page, int rows) {
        BaseResultVo<TechnologyPlan> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        TechnologyPlan technologyPlan = new TechnologyPlan();
        technologyPlan.setTechnologyName("%" + searchValue +"%");
        int total = technologyPlanMapper.selectCountTechnologyPlanByCondition(technologyPlan);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.searchTechnologyPlanByCondition(technologyPlan, rows, offset);
        //封装list和total
        baseResultVo.setRows(technologyPlans);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }
}
