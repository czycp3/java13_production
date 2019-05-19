package com.cskaoyan.service;

import com.cskaoyan.bean.Measure;


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
}
