package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.TechnologyException;

import java.util.List;

public interface ProcessService {

    /**
     * 查询工序列表
     * @param page
     * @param rows
     * @return
     */
    List<Process> selectAllProcess(int page, int rows);

    /**
     * 查询工序总条目数
     * @return 总条目数
     */
    int selectCountProcess();

    /**
     * 插入一条数据
     * @param process
     * @return
     */
    QueryStatus insert(Process process);

    /**
     * 删除
     * @param ids
     * @return
     */
    QueryStatus deleteBatch(String[] ids) throws TechnologyException;

    /**
     * 更新某个工序
     * @param process
     * @return
     */
    QueryStatus updateAll(Process process);

    /**
     * 按工序编号模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    BaseResultVo searchProcessByProcessId(String searchValue, int page, int rows);

    /**
     * 按工序计划编号模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    BaseResultVo searchProcessByTechnologyPlanId(String searchValue, int page, int rows);

}
