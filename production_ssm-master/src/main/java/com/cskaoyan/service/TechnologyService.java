package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.exception.TechnologyException;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @Author cly
 */
public interface TechnologyService {

    /**
     * 分页查找所有工艺
     * @param page 当前页
     * @param rows 每页显示行数
     * @return List<Technology>
     */
    List<Technology> selectAllTechnology(int page, int rows);

    /**
     * 查询工艺总条目数
     * @return 总条目数
     */
    int selectCountTechnology();

    /**
     * 插入一条数据
     * @param record
     * @return
     */
    QueryStatus insert(Technology record);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    QueryStatus deleteBatch(String[] ids) throws TechnologyException;

    /**
     * 更新
     * @param technology
     * @return
     */
    QueryStatus updateAll(Technology technology);

    /**
     * 按工艺编号模糊查找
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    BaseResultVo searchTechnologyById(String searchValue, int page, int rows);

    /**
     * 按工艺名称模糊查找
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    BaseResultVo searchTechnologyByName(String searchValue, int page, int rows);

    /**
     * 查询所有工艺
     * @return
     */
    List<Technology> selectByExample();
}
