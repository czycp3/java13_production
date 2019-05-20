package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Work;
import com.cskaoyan.exception.WorkException;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public interface WorkService {
    /**
     * 分页查询所有作业
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo selectAllWork(int page, int rows);

    /**
     * 新增作业
     * @param work
     * @return QueryStatus
     */
    QueryStatus insert(Work work);

    /**
     * 更新作业
     * @param work
     * @return QueryStatus
     */
    QueryStatus updateByPrimaryKeySelective(Work work);

    /**
     * 批量删除作业
     * @param ids
     * @return QueryStatus
     */
    QueryStatus deleteBatch(String[] ids) throws WorkException;

    /**
     * 按照workId模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchWorkById(String searchValue, int page, int rows);

    /**
     * 按照Product模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchWorkByProduct(String searchValue, int page, int rows);

    /**
     * 按照Device模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchWorkByDevice(String searchValue, int page, int rows);

    /**
     * 按照Device模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchWorkByProcess(String searchValue, int page, int rows);

    Work searchWorkDetail(String workId);

    List<Work> searchWorkList();

}
