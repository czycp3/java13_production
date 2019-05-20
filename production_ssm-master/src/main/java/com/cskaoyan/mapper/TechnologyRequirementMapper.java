package com.cskaoyan.mapper;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.exception.TechnologyException;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface TechnologyRequirementMapper {

    /**
     * 分页查询工艺要求列表
     * @param rows
     * @param offset
     * @return
     */
    List<TechnologyRequirement> selectAllTechnologyRequirement(@Param("rows") int rows, @Param("offset") int offset);

    /**
     * 分页查询工艺要求列表总条目数
     * @return
     */
    int selectCountTechnologyRequirement();

    /**
     * 插入
     * @param technologyRequirement
     */
    void insert(TechnologyRequirement technologyRequirement);

    /**
     * 批量删除
     * @param id
     */
    void deleteByPrimaryKey(String id);

    /**
     * 更新
     * @param technologyRequirement
     */
    void updateAllByTechnologyRequirementId(TechnologyRequirement technologyRequirement) throws SQLException;

    /**
     * 统计按工艺要求编号模糊查询的总条目数
     * @param technologyRequirement
     * @return
     */
    int selectCountTechnologyRequirementByCondition(@Param("technologyRequirement") TechnologyRequirement technologyRequirement);

    /**
     * 按工艺要求编号查询列表
     * @param technologyRequirement
     * @param rows
     * @param offset
     * @return
     */
    List<TechnologyRequirement> searchTechnologyRequirementByCondition(@Param("technologyRequirement") TechnologyRequirement technologyRequirement, @Param("rows") int rows, @Param("offset") int offset);


    void updateRequirementById(@Param("technologyRequirement") TechnologyRequirement technologyRequirement) throws SQLException;
}
