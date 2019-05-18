package com.cskaoyan.mapper;

import com.cskaoyan.bean.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CZY-Y7000P
 * 客户mapper接口
 */
public interface CustomMapper {

    /**
     * 按customId删除客户
     * @param customId
     * @return 成功行数
     */
    int deleteByPrimaryKey(@Param("customId") String customId);

    /**
     * 插入一个客户
     * @param record
     * @return 成功行数
     */
    int insert(@Param("record") Custom record);

    /**
     * 选择字段插入客户
     * @param record
     * @return 成功行数
     */
    int insertSelective(Custom record);

    /**
     * 按客户ID查询客户
     * @param customId
     * @return Custom
     */
    Custom selectByPrimaryKey(String customId);

    /**
     * 按所选字段更新客户
     * @param record
     * @return 更新成功行数
     */
    int updateByPrimaryKeySelective(Custom record);

    /**
     * 按客户ID更新客户信息
     * @param record
     * @return 更新成功行数

     */
    int updateByPrimaryKey(Custom record);

    /**
     * 查询客户列表
     *  @param offset 偏移量
     *  @param rows 每页行数
     *  @return List<Custom>
     */
    List<Custom> selectAllCustom(@Param("rows") int rows,@Param("offset") int offset);

    /**
     * 查询custom表中总条目数
     * @return 总条目数
     */
    int selectCountCustom();

    /**
     * 按条件查询custom表中总条目数
     * @param  record 封装的条件
     * @return 总条目数
     */
    int selectCountCustomByCondition(@Param("record") Custom record);

    /**
     * 按条件查询custom
     * @param  record 封装的条件
     * @param  rows 查询条目数
     * @param offset 偏移量
     * @return 总条目数
     */
    List<Custom> searchCustomByCondition(@Param("record") Custom record, @Param("rows") int rows, @Param("offset") int offset);

}