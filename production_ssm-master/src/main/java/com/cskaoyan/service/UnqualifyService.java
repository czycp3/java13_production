package com.cskaoyan.service;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Unqualify;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-17 23:46
 */

public interface UnqualifyService {
    //分页查询不合格品列表
    List<Unqualify> findList(int rows, int offset);

    //查找所有的数据项
    List<Unqualify> findAllList();

    //插入新的不合格商品的信息
    QueryStatus insert(Unqualify unqualify);



}
