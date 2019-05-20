package com.cskaoyan.service;

import com.cskaoyan.bean.PMeasureCheck;
import com.cskaoyan.bean.QueryStatus;

import java.util.Collection;
import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 22:40
 */
public interface PMeasureCheckService {

    List<PMeasureCheck> findList(Integer rows, int offset);

    List<PMeasureCheck> findAllList();

    QueryStatus insert(PMeasureCheck pMeasureCheck);

    QueryStatus updateAll(PMeasureCheck pMeasureCheck);

    QueryStatus updateNote(String pMeasureCheckId, String note);

    QueryStatus deleteBatch(String[] ids);

    List<PMeasureCheck> searchById(String searchValue, Integer rows, int offset);

    List<PMeasureCheck> searchAllById(String searchValue);
}
