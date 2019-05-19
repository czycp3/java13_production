package com.cskaoyan.service.impl;

import com.cskaoyan.bean.PMeasureCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.PMeasureCheckMapper;
import com.cskaoyan.service.PMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 22:41
 */
@Service
public class PMeasureCheckServiceImpl implements PMeasureCheckService {
    @Autowired
    PMeasureCheckMapper pMeasureCheckMapper;


    @Override
    public List<PMeasureCheck> findList(Integer rows, int offset) {
        List<PMeasureCheck> list = pMeasureCheckMapper.findList(rows, offset);
        return list;
    }

    @Override
    public List<PMeasureCheck> findAllList() {
        List<PMeasureCheck> allList = pMeasureCheckMapper.findAllList();
        return allList;
    }

    @Override
    public QueryStatus insert(PMeasureCheck pMeasureCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = pMeasureCheckMapper.insert(pMeasureCheck);
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
    public QueryStatus updateAll(PMeasureCheck pMeasureCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = pMeasureCheckMapper.updateAll(pMeasureCheck);
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
    public QueryStatus updateNote(String pMeasureCheckId, String note) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = pMeasureCheckMapper.updateNote(pMeasureCheckId,note);
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
                pMeasureCheckMapper.deleteBatch(ids[i]);
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
    public List<PMeasureCheck> searchById(String searchValue, Integer rows, int offset) {
        List<PMeasureCheck> list = pMeasureCheckMapper.searchById(searchValue,rows,offset);
        return list;
    }

    @Override
    public List<PMeasureCheck> searchAllById(String searchValue) {
        List<PMeasureCheck> allList = pMeasureCheckMapper.searchAllById(searchValue);
        return allList;
    }
}
