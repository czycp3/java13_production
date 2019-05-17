package com.cskaoyan.service;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.CustomException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public interface CustomService {

    Custom selectByPrimaryKey(String customId);

    /**
     * 查询客户列表
     * @return List<Custom>
     */
    List<Custom> selectAllCustom();

    /**
     * 插入一个客户
     * @param record
     * @return 成功行数
     */
    QueryStatus insert(@Param("record") Custom record);

    /**
     * 批量刪除客戶
     * @param ids
     * @return
     */
    QueryStatus deleteBatch(String[] ids) throws CustomException;

    /**
     * 选择字段更新客户信息
     * @param record
     * @return
     */
    QueryStatus updateByPrimaryKeySelective(Custom record);
}
