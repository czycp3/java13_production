package com.cskaoyan.service.impl;

import com.cskaoyan.bean.FCountCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.FCountCheckMapper;
import com.cskaoyan.service.FCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 19:30
 */
@Service
public class FCountCheckServiceImpl implements FCountCheckService {

    @Autowired
    FCountCheckMapper fCountCheckMapper;

    //分页查找
    @Override
    public List<FCountCheck> findList(Integer rows, int offset) {
        List<FCountCheck> measureList = fCountCheckMapper.findList(rows, offset);
        return measureList;
    }

    //查找所有
    @Override
    public List<FCountCheck> findAllList() {
        List<FCountCheck> measureList = fCountCheckMapper.findAllList();
        return measureList;
    }

    //增加
    @Override
    public QueryStatus insert(FCountCheck fCountCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = fCountCheckMapper.insert(fCountCheck);
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


    //修改所有
    @Override
    public QueryStatus update_all(FCountCheck fCountCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = fCountCheckMapper.update_all(fCountCheck);
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

    //修改备注信息
    @Override
    public QueryStatus update_note(String fCountCheckId, String note) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = fCountCheckMapper.update_note(fCountCheckId , note);
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
                fCountCheckMapper.delete_batch(ids[i]);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除失败");
        }


        return queryStatus;
    }


    //根据id查询-分页
    @Override
    public List<FCountCheck> searchfMeasureCheckByfMeasureCheckId(String searchValue, Integer rows, int offset) {
        List<FCountCheck> measureList = fCountCheckMapper.searchfMeasureCheckByfMeasureCheckId(searchValue,rows,offset);
        return measureList;
    }

    //根据id查询-所有
    @Override
    public List<FCountCheck> searchAllfMeasureCheckByfMeasureCheckId(String searchValue) {
        List<FCountCheck> measureAllList = fCountCheckMapper.searchAllfMeasureCheckByfMeasureCheckId(searchValue);
        return measureAllList;
    }

    @Override
    public List<FCountCheck> searchfMeasureCheckByOrderId(String searchValue, Integer rows, int offset) {
        List<FCountCheck> measureList = fCountCheckMapper.searchfMeasureCheckByOrderId(searchValue,rows,offset);
        return measureList;
    }

    @Override
    public List<FCountCheck> searchAllfMeasureCheckByOrderId(String searchValue) {
        List<FCountCheck> measureAllList = fCountCheckMapper.searchAllfMeasureCheckByOrderId(searchValue);
        return measureAllList;
    }
}
