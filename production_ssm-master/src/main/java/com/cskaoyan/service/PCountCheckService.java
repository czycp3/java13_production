package com.cskaoyan.service;

import com.cskaoyan.bean.PCountCheck;
import com.cskaoyan.bean.PMeasureCheck;
import com.cskaoyan.bean.QueryStatus;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 00:29
 */
public interface PCountCheckService {
    List<PCountCheck> findList(Integer rows, int offset);

    List<PCountCheck> findAllList();

    QueryStatus insert(PCountCheck pCountCheck);

    QueryStatus updateAll(PCountCheck pCountCheck);

    QueryStatus updateNote(String pCountCheckId, String note);

    QueryStatus deleteBatch(String[] ids);

    List<PCountCheck> searchById(String searchValue, Integer rows, int offset);

    List<PCountCheck> searchAllById(String searchValue);
}
