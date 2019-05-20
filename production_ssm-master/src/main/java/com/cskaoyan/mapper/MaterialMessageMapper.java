package com.cskaoyan.mapper;

import com.cskaoyan.bean.MaterialMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author q4work
 * 客户mapper接口
 */
public interface MaterialMessageMapper {
    /**
     * @author q4work
     * 查询所有物料信息
     */
    public List<MaterialMessage> queryAllMaterialMessage();

    public boolean inserMaterialMessage(MaterialMessage materialMessage);

    public List<MaterialMessage> queryMaterialById(String searchValue);

    public List<MaterialMessage> queryMaterialByType(String searchValue);

    public boolean deleteMaterialById(@Param("ids") String[] ids,@Param("len") int lenth);

    public boolean materialEdit(MaterialMessage materialMessage);
}
