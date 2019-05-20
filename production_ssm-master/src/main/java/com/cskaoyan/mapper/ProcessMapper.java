package com.cskaoyan.mapper;

import com.cskaoyan.bean.Process;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface ProcessMapper {
    /**
     * 查询工序列表
     * @param rows
     * @param offset
     * @return
     */
    List<Process> selectAllProcess(@Param("rows") int rows, @Param("offset") int offset);

    /**
     * 查询工序总条目数
     * @return
     */
    int selectCountProcess();

    /**
     * 插入一条数据
     * @param process
     */
    void insert(Process process);

    /**
     * 删除一条数据
     * @param id
     */
    void deleteByPrimaryKey(String id);

    /**
     * 更新某个工序
     * @param process
     * @throws SQLException
     */
    void updateAll(Process process) throws SQLException;

    /**
     * 按工序编号模糊查询
     * @param record
     * @return
     */
    int selectCountProcessByCondition(@Param("record") Process record);

    /**
     * 按工序计划编号模糊查询
     * @param process
     * @param rows
     * @param offset
     * @return
     */
    List<Process> searchProcessByCondition(@Param("process") Process process, @Param("rows") int rows,@Param("offset") int offset);

    List<Process> selectAll();

    Process selectByProcessId(@Param("processId") String processId);
}
