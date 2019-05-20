package com.cskaoyan.mapper;

import com.cskaoyan.bean.FCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 19:30
 */

public interface FCountCheckMapper {

    //分页查找
    List<FCountCheck> findList(@Param("rows") Integer rows, @Param("offset")int offset);

    //查找所有
    List<FCountCheck> findAllList();

    //插入
    int insert(@Param("fCountCheck") FCountCheck fCountCheck);

    //修改所有
    int update_all(@Param("fCountCheck") FCountCheck fCountCheck);

    //修改note
    int update_note(@Param("fCountCheckId") String fCountCheckId, @Param("note") String note);

    //删除
    void delete_batch(@Param("id") String id);

    //根据id查询-分页
    List<FCountCheck> searchfMeasureCheckByfMeasureCheckId(@Param("searchValue") String searchValue, @Param("rows") Integer rows,@Param("offset") int offset);

    //根据id查询-所有
    List<FCountCheck> searchAllfMeasureCheckByfMeasureCheckId(@Param("searchValue") String searchValue);

    //根据订单id查询-分页
    List<FCountCheck> searchfMeasureCheckByOrderId(@Param("searchValue") String searchValue, @Param("rows") Integer rows,@Param("offset") int offset);

    //根据订单id查询-所有
    List<FCountCheck> searchAllfMeasureCheckByOrderId(@Param("searchValue") String searchValue);

}
