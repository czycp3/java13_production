package com.cskaoyan.service.impl;

import com.cskaoyan.bean.MaterialMessage;
import com.cskaoyan.mapper.MaterialConsumeMapper;
import com.cskaoyan.mapper.MaterialMessageMapper;
import com.cskaoyan.service.MaterialConsumeService;
import com.cskaoyan.service.MaterialMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    private MaterialConsumeMapper mapper;

    @Autowired
    public MaterialConsumeServiceImpl(MaterialConsumeMapper mapper) {
        this.mapper = mapper;
    }
}
