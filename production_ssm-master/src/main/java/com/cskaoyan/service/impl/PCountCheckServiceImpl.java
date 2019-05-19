package com.cskaoyan.service.impl;

import com.cskaoyan.bean.PCountCheck;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.PCountCheckMapper;
import com.cskaoyan.service.PCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 00:29
 */
@Service
public class PCountCheckServiceImpl implements PCountCheckService {
    @Autowired
    PCountCheckMapper pCountCheckMapper;

    @Override
    public List<PCountCheck> findList(Integer rows, int offset) {
        List<PCountCheck> list = pCountCheckMapper.findList(rows, offset);
        return list;
    }

    @Override
    public List<PCountCheck> findAllList() {
        List<PCountCheck> allList = pCountCheckMapper.findAllList();
        return allList;
    }

    @Override
    public QueryStatus insert(PCountCheck pCountCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = pCountCheckMapper.insert(pCountCheck);
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

    @Override
    public QueryStatus updateAll(PCountCheck pCountCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = pCountCheckMapper.updateAll(pCountCheck);
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

    @Override
    public QueryStatus updateNote(String pCountCheckId, String note) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = pCountCheckMapper.updateNote(pCountCheckId,note);
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


    @Override
    public QueryStatus deleteBatch(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            for (int i = 0; i < ids.length; i++) {
                pCountCheckMapper.deleteBatch(ids[i]);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除失败");
        }


        return queryStatus;
    }

    @Override
    public List<PCountCheck> searchById(String searchValue, Integer rows, int offset) {
        List<PCountCheck> list = pCountCheckMapper.searchById(searchValue,rows,offset);
        return list;
    }

    @Override
    public List<PCountCheck> searchAllById(String searchValue) {
        List<PCountCheck> allList = pCountCheckMapper.searchAllById(searchValue);
        return allList;
    }
}
