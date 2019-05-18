package com.cskaoyan.mapper;

import com.cskaoyan.bean.Unqualify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-17 23:46
 */

public interface UnqualifyMapper {
    //分页查找
    List<Unqualify> findList(@Param("rows") int rows, @Param("offset") int offset);

    //分页查找
    List<Unqualify> findAllList();

    //新增不合格品信息
    int insert(@Param("unqualify") Unqualify unqualify);

}
