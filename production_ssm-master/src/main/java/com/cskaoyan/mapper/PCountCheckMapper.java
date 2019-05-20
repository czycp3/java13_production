package com.cskaoyan.mapper;

import com.cskaoyan.bean.PCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 00:38
 */
public interface PCountCheckMapper {

    List<PCountCheck> findList(@Param("rows") Integer rows, @Param("offset")int offset);

    List<PCountCheck> findAllList();


    int insert(@Param("pCountCheck") PCountCheck pCountCheck);

    int updateAll(@Param("pCountCheck")PCountCheck pCountCheck);

    int updateNote(@Param("pCountCheckId")String pCountCheckId, @Param("note") String note);

    void deleteBatch(@Param("id")String id);

    List<PCountCheck> searchById(@Param("searchValue") String searchValue, @Param("rows") Integer rows,@Param("offset") int offset);

    List<PCountCheck> searchAllById(@Param("searchValue") String searchValue);
}
