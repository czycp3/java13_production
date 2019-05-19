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

    //插入
    int insert(@Param("measure") Measure measure);

    //修改所有
    int update_all(@Param("measure") Measure measure);

    //修改note
    int update_note(@Param("fMeasureCheckId") String fMeasureCheckId, @Param("note") String note);

    //删除
    void delete_batch(@Param("id") String id);

    //根据id查询-分页
    List<Measure> searchfMeasureCheckByfMeasureCheckId(@Param("searchValue") String searchValue, @Param("rows") Integer rows,@Param("offset") int offset);

    //根据id查询-所有
    List<Measure> searchAllfMeasureCheckByfMeasureCheckId(@Param("searchValue") String searchValue);

    //根据订单id查询-分页
    List<Measure> searchfMeasureCheckByOrderId(@Param("searchValue") String searchValue, @Param("rows") Integer rows,@Param("offset") int offset);

    //根据订单id查询-所有
    List<Measure> searchAllfMeasureCheckByOrderId(@Param("searchValue") String searchValue);
}

