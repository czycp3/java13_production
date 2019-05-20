package com.cskaoyan.service.impl;

import com.cskaoyan.bean.MaterialMessage;
import com.cskaoyan.mapper.MaterialMessageMapper;
import com.cskaoyan.service.MaterialMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialMessageServiceImpl implements MaterialMessageService {

    private MaterialMessageMapper mapper;

    @Autowired
    public MaterialMessageServiceImpl(MaterialMessageMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<MaterialMessage> queryAllMaterialMessage() {
        return mapper.queryAllMaterialMessage();
    }

    @Override
    public boolean insertMaterialMessage(MaterialMessage materialMessage) {
        System.out.println(materialMessage);
        boolean b = mapper.inserMaterialMessage(materialMessage);
        return b;
    }

    @Override
    public List<MaterialMessage> queryMaterialById(String searchValue) {
        List<MaterialMessage> list = mapper.queryMaterialById(searchValue);
        return list;
    }

    @Override
    public List<MaterialMessage> queryMaterialByType(String searchValue) {
        List<MaterialMessage> list = mapper.queryMaterialByType(searchValue);
        return list;
    }

    @Override
    public int deleteMaterialById(String[] ids) {
        mapper.deleteMaterialById(ids,ids.length);
        return 111;
    }

    @Override
    public int materialEdit(MaterialMessage materialMessage) {
        mapper.materialEdit(materialMessage);
        return 0;
    }
}
