package com.cskaoyan.mapper;

import com.cskaoyan.bean.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveMapper {
    List queryAllMaterialReceive();

    boolean deleteById(@Param("ids") String[] ids);

    boolean insertmaterialReceive(@Param("mr") MaterialReceive materialReceive,@Param("id") String materialId);

    void materialReceiveUpdateAll(@Param("mr") MaterialReceive materialReceive, @Param("id")String materialId);
}
