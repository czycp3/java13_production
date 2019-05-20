package com.cskaoyan.mapper;

import com.cskaoyan.bean.PMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 22:58
 */
public interface PMeasureCheckMapper {

    List<PMeasureCheck> findList(@Param("rows") Integer rows, @Param("offset")int offset);

    List<PMeasureCheck> findAllList();


    int insert(@Param("pMeasureCheck") PMeasureCheck pMeasureCheck);

    int updateAll(@Param("pMeasureCheck")PMeasureCheck pMeasureCheck);

    int updateNote(@Param("pMeasureCheckId")String pMeasureCheckId, @Param("note") String note);

    void deleteBatch(@Param("id")String id);

    List<PMeasureCheck> searchById(@Param("searchValue") String searchValue, @Param("rows") Integer rows,@Param("offset") int offset);

    List<PMeasureCheck> searchAllById(@Param("searchValue") String searchValue);
}
