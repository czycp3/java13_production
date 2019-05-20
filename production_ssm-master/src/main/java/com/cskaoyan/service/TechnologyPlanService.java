package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.exception.TechnologyException;

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

    /**
     * 分页查询工艺计划列表
     * @param page
     * @param rows
     * @return
     */
    List<TechnologyPlan> selectAllTechnologyPlan(int page, int rows);

    /**
     * 查询工艺计划总条目数
     * @return
     */
    int selectCountTechnologyPlan();

    /**
     * 添加
     * @param technologyPlan
     * @return
     */
    QueryStatus insert(TechnologyPlan technologyPlan);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    QueryStatus deleteBatch(String[] ids) throws TechnologyException;

    /**
     * 按工艺计划编号模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    BaseResultVo searchTechnologyPlanByTechnologyPlanId(String searchValue, int page, int rows);

    BaseResultVo searchTechnologyPlanbyTechnologyName(String searchValue, int page, int rows);
}
