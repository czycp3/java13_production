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
     * @param customId
     * @return 成功行数
     * 按customId删除客户
     */
    int deleteByPrimaryKey(@Param("customId") String customId);

    /**
     * @param record
     * @return 成功行数
     * 插入一个客户
     */
    int insert(@Param("record") Custom record);

    /**
     * @param record
     * @return 成功行数
     * 选择字段插入客户
     */
    int insertSelective(Custom record);

    /**
     * @param customId
     * @return Custom
     * 按客户ID查询客户
     */
    Custom selectByPrimaryKey(String customId);

    /**
     * @param record
     * @return 更新成功行数
     * 按所选字段更新客户
     */
    int updateByPrimaryKeySelective(Custom record);

    /**
     * @param record
     * @return 更新成功行数
     * 按客户ID更新客户信息
     */
    int updateByPrimaryKey(Custom record);

    /**
     * @return List<Custom>
     * 查询客户列表
     */
    List<Custom> selectAllCustom();
}