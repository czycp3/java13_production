package com.cskaoyan.mapper;

import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.TaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author CZY-Y7000P
 */
public interface TaskMapper {
    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    /**
     * 分页查询所有派工
     * @param rows
     * @param offset
     * @return List<Task>
     */
    List<Task> selectAllTask(@Param("rows") int rows, @Param("offset") int offset);

    /**
     * 条件查询task总数
     * @param task
     * @return 总数
     */
    int selectCountTaskByCondition(@Param("task") Task task);

    /**
     * 条件查询所有task
     * @param task
     * @param rows
     * @param offset
     * @return List<Task>
     */
    List<Task> searchTaskByCondition(@Param("task")Task task, @Param("rows") int rows, @Param("offset") int offset);
}
