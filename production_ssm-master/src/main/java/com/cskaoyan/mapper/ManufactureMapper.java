package com.cskaoyan.mapper;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.ManufactureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufactureMapper {
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    /**
     * xxxxxxxxxxxxxx
     * @param rows
     * @param offset
     * @return
     */
    List<Manufacture> selectAllManufacture(@Param("rows")int rows, @Param("offset") int offset);

    /**
     * 条件查询
     * @param manufacture
     * @return 条目数
     */
    int selectCountOrderByCondition(@Param("manufacture") Manufacture manufacture);

    /**
     * 条件查询
     * @param manufacture
     * @param rows
     * @param offset
     * @return 条目数
     */
    List<Manufacture> searchOrderByCondition(@Param("manufacture") Manufacture manufacture, @Param("rows") int rows, @Param("offset") int offset);
}
