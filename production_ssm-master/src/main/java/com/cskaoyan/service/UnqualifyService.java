package com.cskaoyan.service;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Unqualify;

import java.util.Collection;
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

    //修改不合格商品所有信息
    QueryStatus update_all(Unqualify unqualify);

    //修改不合格商品备注信息
    QueryStatus update_note(String unqualifyApplyId, String note);

    //删除信息
    QueryStatus delete_batch(String[] ids);

    //根据id查找分页
    List<Unqualify> searchUnqualifyByUnqualifyId(String searchValue, Integer rows, int offset);

    //根据id查找的所有条目
    List<Unqualify> searchAllUnqualifyByUnqualifyId(String searchValue);

    //根据产品名称查找分页
    List<Unqualify> searchUnqualifyByPAgeByProductName(String searchValue, Integer rows, int offset);

    //根据产品名称查找所有条目
    List<Unqualify> searchAllUnqualifyByProductName(String searchValue);
}
