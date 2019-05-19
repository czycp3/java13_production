package com.cskaoyan.mapper;

import com.cskaoyan.bean.Measure;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 11:31
 */
public interface MeasureMapper {
    //分页查找
    List<Measure> findList(@Param("rows") int rows, @Param("offset") int offset);

    //分页查找
    List<Measure> findAllList();
}
