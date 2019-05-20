package com.cskaoyan.service;

import com.cskaoyan.bean.MaterialMessage;

import java.util.List;
/**
 * @author q4work
 */
public interface MaterialMessageService {
    public List<MaterialMessage> queryAllMaterialMessage();

    public boolean insertMaterialMessage(MaterialMessage materialMessage);

    public List<MaterialMessage> queryMaterialById(String searchValue);

    public List<MaterialMessage> queryMaterialByType(String searchValue);

    public int deleteMaterialById(String[] ids);

    int materialEdit(MaterialMessage materialMessage);
}
