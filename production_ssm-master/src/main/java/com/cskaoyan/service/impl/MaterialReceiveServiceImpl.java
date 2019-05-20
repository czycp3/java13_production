package com.cskaoyan.service.impl;

import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.mapper.MaterialReceiveMapper;
import com.cskaoyan.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
    @Autowired
    MaterialReceiveMapper mapper;

    @Override
    public List queryAllMaterialReceive() {
        List list = mapper.queryAllMaterialReceive();
        return list;
    }

    @Override
    public int deleteById(String[] ids) {
        mapper.deleteById(ids);
        return 111;
    }

    @Override
    public boolean insertmaterialReceive(MaterialReceive materialReceive, String materialId) {
        return mapper.insertmaterialReceive(materialReceive,materialId);

    }

    @Override
    public int materialReceiveUpdateAll(MaterialReceive materialReceive, String materialId) {
        mapper.materialReceiveUpdateAll(materialReceive,materialId);
        return 111;
    }

}
