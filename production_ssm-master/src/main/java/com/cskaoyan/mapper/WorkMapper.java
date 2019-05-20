package com.cskaoyan.mapper;

import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.WorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    /**
     * 分页查询所有作业
     * @param rows
     * @param offset
     * @return List<Work>
     */
    List<Work> selectAllWork(@Param("rows") int rows, @Param("offset") int offset);

    /**
     * 按条件查询作业总数
     * @param work
     * @return 作业数量
     */
    int selectCountWorkByCondition(@Param("work") Work work);

    /**
     * 按条件查询作业
     * @param work
     * @param rows
     * @param offset
     * @return List<Work>
     */
    List<Work> searchWorkByCondition(@Param("work") Work work, @Param("rows") int rows, @Param("offset") int offset);

    List<Work> selectWork();

    Work selectMultByPrimaryKey(@Param("workId") String workId);
}
