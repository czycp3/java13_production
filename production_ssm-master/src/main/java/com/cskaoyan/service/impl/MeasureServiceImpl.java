package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Measure;
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


    @Override
    public List<Measure> findList(int rows, int offset) {
        List<Measure> measureList = measureMapper.findList(rows, offset);
        return measureList;
    }

    @Override
    public List<Measure> findAllList() {
        List<Measure> measureAllList = measureMapper.findAllList();
        return measureAllList;
    }

}
