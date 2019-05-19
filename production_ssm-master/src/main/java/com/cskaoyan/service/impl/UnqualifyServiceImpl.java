package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Unqualify;
import com.cskaoyan.mapper.UnqualifyMapper;
import com.cskaoyan.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-17 23:46
 */

@Service
public class UnqualifyServiceImpl implements UnqualifyService {

    @Autowired
    UnqualifyMapper unqualifyMapper;

    //分页查询不合格品列表
    @Override
    public List<Unqualify> findList(int rows, int offset) {
        List<Unqualify> unqualifyList = unqualifyMapper.findList(rows, offset);
        return unqualifyList;
    }

    //查询总的记录数
    @Override
    public List<Unqualify> findAllList() {
        List<Unqualify> unqualifyList = unqualifyMapper.findAllList();
        return unqualifyList;
    }

    //新增不合格信息
    @Override
    public QueryStatus insert(Unqualify unqualify) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = unqualifyMapper.insert(unqualify);
            if (i == 1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            } else {
                queryStatus.setStatus(404);
                queryStatus.setMsg("插入失败");
            }
        }catch (Exception e){
            queryStatus.setStatus(404);
            queryStatus.setMsg("不合格品申请编号重复，请重新申请");
        }
        return queryStatus;
    }

    //修改不合格产品所有信息
    @Override
    public QueryStatus update_all(Unqualify unqualify) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = unqualifyMapper.update_all(unqualify);
            if (i == 1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            } else {
                queryStatus.setStatus(404);
                queryStatus.setMsg("修改失败");
            }
        }catch (Exception e){
            queryStatus.setStatus(404);
            queryStatus.setMsg("不合格品申请编号重复，请重新申请");
        }
        return queryStatus;
    }


    //修改不合格产品备注信息
    @Override
    public QueryStatus update_note(String unqualifyApplyId, String note) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = unqualifyMapper.update_note(unqualifyApplyId , note);
            if (i == 1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            } else {
                queryStatus.setStatus(404);
                queryStatus.setMsg("修改失败");
            }
        }catch (Exception e){
            queryStatus.setStatus(404);
            queryStatus.setMsg("不合格品申请编号重复，请重新申请");
        }
        return queryStatus;
    }

    //删除
    @Override
    public QueryStatus delete_batch(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            for (int i = 0; i < ids.length; i++) {
                unqualifyMapper.delete_batch(ids[i]);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除失败");
        }


        return queryStatus;
    }

    //根据ID来查找不良产品/分页
    @Override
    public List<Unqualify> searchUnqualifyByUnqualifyId(String searchValue, Integer rows, int offset) {
        List<Unqualify> unqualifyList = unqualifyMapper.searchUnqualifyByUnqualifyId(searchValue,rows, offset);
        return unqualifyList;
    }

    //根据ID来查找不良产品/所有条目
    @Override
    public List<Unqualify> searchAllUnqualifyByUnqualifyId(String searchValue) {
        List<Unqualify> unqualifyList = unqualifyMapper.searchAllUnqualifyByUnqualifyId(searchValue);
        return unqualifyList;
    }


    @Override
    public List<Unqualify> searchUnqualifyByPAgeByProductName(String searchValue, Integer rows, int offset) {
        List<Unqualify> unqualifyListByPage = unqualifyMapper.searchUnqualifyByPAgeByProductName(searchValue,rows,offset);

        return unqualifyListByPage;
    }

    @Override
    public List<Unqualify> searchAllUnqualifyByProductName(String searchValue) {
        List<Unqualify> unqualifyList = unqualifyMapper.searchAllUnqualifyByProductName(searchValue);
        return unqualifyList;
    }
}
