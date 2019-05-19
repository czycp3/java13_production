package com.cskaoyan.mapper;

import com.cskaoyan.bean.Product;
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

    //修改不合格信息
    int update_all(@Param("unqualify") Unqualify unqualify);

    //修改不合格备注信息
    int update_note(@Param("unqualifyApplyId") String unqualifyApplyId, @Param("note") String note);

    //删除
    int delete_batch(@Param("id") String id);

    //根据ID来查找不良产品/分页
    List<Unqualify> searchUnqualifyByUnqualifyId(@Param("searchValue") String searchValue, @Param("rows") Integer rows,@Param("offset") int offset);

    //根据ID来查找不良产品/所有条目
    List<Unqualify> searchAllUnqualifyByUnqualifyId(@Param("searchValue") String searchValue);

    //根据product的名字模糊查询product的id
    List<Product> findProductId(@Param("searchValue") String searchValue);



    //根据product的名字模糊查询--分页
    List<Unqualify> searchUnqualifyByPAgeByProductName(@Param("searchValue") String searchValue, @Param("rows") Integer rows,@Param("offset") int offset);

    //根据product的名字模糊查询--分页
    List<Unqualify> searchAllUnqualifyByProductName(@Param("searchValue")String searchValue);
}
