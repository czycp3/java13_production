package com.cskaoyan.service;

import com.cskaoyan.bean.FCountCheck;
import com.cskaoyan.bean.QueryStatus;

import java.util.Collection;
import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 19:29
 */
public interface FCountCheckService {

    //分页查找
    List<FCountCheck> findList(Integer rows, int offset);

    //查找所有
    List<FCountCheck> findAllList();

    //增加
    QueryStatus insert(FCountCheck fCountCheck);

    //修改所有
    QueryStatus update_all(FCountCheck fCountCheck);

    //修改note
    QueryStatus update_note(String fCountCheckId, String note);

    //删除
    QueryStatus delete_batch(String[] ids);


    //根据id查询-分页
    List<FCountCheck> searchfMeasureCheckByfMeasureCheckId(String searchValue, Integer rows, int offset);

    //根据id查询-所有
    List<FCountCheck> searchAllfMeasureCheckByfMeasureCheckId(String searchValue);

    //根据订单id查询-分页
    List<FCountCheck> searchfMeasureCheckByOrderId(String searchValue, Integer rows, int offset);
    //根据订单id查询-所有
    List<FCountCheck> searchAllfMeasureCheckByOrderId(String searchValue);


}
