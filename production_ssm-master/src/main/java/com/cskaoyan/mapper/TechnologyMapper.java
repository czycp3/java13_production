package com.cskaoyan.mapper;

import com.cskaoyan.bean.Technology;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface TechnologyMapper {

    /**
     * 查询工艺表中总条目数
     * @return 总条目数
     */
    int selectCountTechnology();

    /**
     * 查询工艺列表
     * @param rows 每页显示行数
     * @param offset 偏移量
     * @return List<Technology>
     */
    List<Technology> selectAllTechnology(@Param("rows") int rows, @Param("offset") int offset);

    /**
     * 插入一条数据
     * @param record
     * @return
     */
    void insert(Technology record);

    /**
     * 根据id删除
     * @param technologyId
     */
    int deleteByPrimaryKey(@Param("technologyId") String technologyId);

    /**
     * 更新某个工艺
     * @param technology
     * @return
     * @throws SQLException
     */
    void updateAll(Technology technology) throws SQLException;

    /**
     * 按条件统计该条件下的总条目数
     * @param record
     * @return
     */
    int selectCountTechnologyByCondition(@Param("record") Technology record);

    /**
     * 按条件查询列表
     * @param technology
     * @param rows
     * @param offset
     * @return
     */
    List<Technology> searchTechnologyByCondition(@Param("technology") Technology technology, @Param("rows") int rows, @Param("offset") int offset);

    /**
     * 查询所有工艺
     * @return
     */
    List<Technology> selectToTalTechnology();

    Technology selectByTechnologyId(String technologyId);
}
