package com.cskaoyan.mapper;

import com.cskaoyan.bean.FCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 19:30
 */

public interface FCountCheckMapper {

    //分页查找
    List<FCountCheck> findList(@Param("rows") Integer rows, @Param("offset")int offset);

    //查找所有
    List<FCountCheck> findAllList();

}
