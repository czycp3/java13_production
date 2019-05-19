package com.cskaoyan.service;

import com.cskaoyan.bean.FCountCheck;

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


}
