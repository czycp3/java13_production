package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Measure;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.MeasureMapper;
import com.cskaoyan.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 11:30
 */
@Service
public class MeasureServiceImpl implements MeasureService {
    @Autowired
    MeasureMapper measureMapper;


    //分页查找
    @Override
    public List<Measure> findList(int rows, int offset) {
        List<Measure> measureList = measureMapper.findList(rows, offset);
        return measureList;
    }

    //查找所有
    @Override
    public List<Measure> findAllList() {
        List<Measure> measureAllList = measureMapper.findAllList();
        return measureAllList;
    }


    //增加
    @Override
    public QueryStatus insert(Measure measure) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = measureMapper.insert(measure);
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
    public QueryStatus update_all(Measure measure) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = measureMapper.update_all(measure);
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
    public QueryStatus update_note(String fMeasureCheckId, String note) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = measureMapper.update_note(fMeasureCheckId , note);
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
                measureMapper.delete_batch(ids[i]);
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
    public List<Measure> searchfMeasureCheckByfMeasureCheckId(String searchValue, Integer rows, int offset) {
        List<Measure> measureList = measureMapper.searchfMeasureCheckByfMeasureCheckId(searchValue,rows,offset);
        return measureList;
    }

    //根据id查询-所有
    @Override
    public List<Measure> searchAllfMeasureCheckByfMeasureCheckId(String searchValue) {
        List<Measure> measureAllList = measureMapper.searchAllfMeasureCheckByfMeasureCheckId(searchValue);
        return measureAllList;
    }

    @Override
    public List<Measure> searchfMeasureCheckByOrderId(String searchValue, Integer rows, int offset) {
        List<Measure> measureList = measureMapper.searchfMeasureCheckByOrderId(searchValue,rows,offset);
        return measureList;
    }

    @Override
    public List<Measure> searchAllfMeasureCheckByOrderId(String searchValue) {
        List<Measure> measureAllList = measureMapper.searchAllfMeasureCheckByOrderId(searchValue);
        return measureAllList;
    }

}
