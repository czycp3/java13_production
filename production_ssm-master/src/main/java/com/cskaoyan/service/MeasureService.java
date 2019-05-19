package com.cskaoyan.service;

import com.cskaoyan.bean.Measure;
import com.cskaoyan.bean.QueryStatus;


import java.util.Collection;
import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 11:30
 */
public interface MeasureService {
    //分页查询
    List<Measure> findList(int rows, int offset);

    //查找所有的数据项
    List<Measure> findAllList();

    //增加
    QueryStatus insert(Measure measure);

    //修改所有
    QueryStatus update_all(Measure measure);

    //修改note
    QueryStatus update_note(String fMeasureCheckId, String note);

    //删除
    QueryStatus delete_batch(String[] ids);

    //根据id查询-分页
    List<Measure> searchfMeasureCheckByfMeasureCheckId(String searchValue, Integer rows, int offset);

    //根据id查询-所有
    List<Measure> searchAllfMeasureCheckByfMeasureCheckId(String searchValue);

    //根据订单id查询-分页
    List<Measure> searchfMeasureCheckByOrderId(String searchValue, Integer rows, int offset);
    //根据订单id查询-所有
    List<Measure> searchAllfMeasureCheckByOrderId(String searchValue);

}
