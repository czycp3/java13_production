package com.cskaoyan.service;

import com.cskaoyan.bean.MaterialReceive;

import java.util.List;

public interface MaterialReceiveService {
    public List queryAllMaterialReceive();

    public int deleteById(String[] ids);

    boolean insertmaterialReceive(MaterialReceive materialReceive, String materialId);

    int materialReceiveUpdateAll(MaterialReceive materialReceive, String materialId);
}
