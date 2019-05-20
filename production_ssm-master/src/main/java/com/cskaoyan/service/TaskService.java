package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Task;
import com.cskaoyan.exception.TaskException;

/**
 * @author CZY-Y7000P
 */
public interface TaskService {
    /**
     * 分页查询所有派工
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo selectAllTask(int page, int rows);

    /**
     * 新增派工
     * @param task
     * @return QueryStatus
     */
    QueryStatus insert(Task task);

    /**
     * 更新派工
     * @param task
     * @return QueryStatus
     */
    QueryStatus updateByPrimaryKeySelective(Task task);

    /**
     * 批量删除派工
     * @param ids
     * @return QueryStatus
     * @throws TaskException
     */
    QueryStatus deleteBatch(String[] ids) throws TaskException;

    /**
     * 按派工ID查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchTaskByTaskId(String searchValue, int page, int rows);

    /**
     * 按作业ID查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchTaskByWorkId(String searchValue, int page, int rows);

    /**
     * 按生产批号ID查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchTaskByManufactureSn(String searchValue, int page, int rows);
}
