package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.exception.TechnologyException;

import java.util.List;

public interface TechnologyRequirementService {
    /**
     * 分页查询工艺要求列表
     * @param page
     * @param rows
     * @return
     */
    List<TechnologyRequirement> selectAllTechnologyRequirement(int page, int rows);

    /**
     * 分页查询工艺要求列表总条目数
     * @return
     */
    int selectCountTechnologyRequirement();

    /**
     * 插入
     * @param technologyRequirement
     * @return
     */
    QueryStatus insert(TechnologyRequirement technologyRequirement);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    QueryStatus deleteBatch(String[] ids) throws TechnologyException;

    /**
     * 更新
     * @param technologyRequirement
     * @return
     */
    QueryStatus updateAll(TechnologyRequirement technologyRequirement);

    /**
     * 按工艺要求编号模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    BaseResultVo searchTechnologyRequirementById(String searchValue, int page, int rows);

    BaseResultVo searchTechnologyRequirementByName(String searchValue, int page, int rows);

    /**
     * 根据Id更新某个工艺要求
     * @param technologyRequirement
     * @return
     */
    QueryStatus updateRequirementById(TechnologyRequirement technologyRequirement);
}
