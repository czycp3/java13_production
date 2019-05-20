package com.cskaoyan.mapper;

import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.exception.TechnologyException;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 分页查询工艺计划列表
     * @param rows
     * @param offset
     * @return
     */
    List<TechnologyPlan> selectAllTechnologyPlan(@Param("rows") int rows, @Param("offset") int offset);

    /**
     * 查询工艺计划表总条目数
     * @return
     */
    int selectCountTechnologyPlan();

    /**
     * 添加
     * @param technologyPlan
     * @throws SQLException
     */
    void insert(TechnologyPlan technologyPlan) throws SQLException;

    /**
     * 批量删除
     * @param id
     * @throws TechnologyException
     */
    void deleteByPrimaryKey(String id) throws TechnologyException;

    int selectCountTechnologyPlanByCondition(@Param("technologyPlan") TechnologyPlan technologyPlan);

    List<TechnologyPlan> searchTechnologyPlanByCondition(@Param("technologyPlan") TechnologyPlan technologyPlan, @Param("rows") int rows, @Param("offset") int offset);
}
