package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CZY
 */
@Service
public class CustomServiceImpl implements CustomService {
    private final CustomMapper customMapper;

    @Autowired
    public CustomServiceImpl(CustomMapper customMapper) {
        this.customMapper = customMapper;
    }

    @Override
    public Custom selectByPrimaryKey(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }

    @Override
    public List<Custom> selectAllCustom() {
        return customMapper.selectAllCustom();
    }
}
