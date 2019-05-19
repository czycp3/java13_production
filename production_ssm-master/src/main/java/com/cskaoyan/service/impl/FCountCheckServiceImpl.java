package com.cskaoyan.service.impl;

import com.cskaoyan.bean.FCountCheck;
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

    @Override
    public List<FCountCheck> findList(Integer rows, int offset) {
        List<FCountCheck> measureList = fCountCheckMapper.findList(rows, offset);
        return measureList;
    }

    @Override
    public List<FCountCheck> findAllList() {
        List<FCountCheck> measureList = fCountCheckMapper.findAllList();
        return measureList;
    }
}
