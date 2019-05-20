package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.ManufactureException;

/**
 * @author CZY-Y7000P
 */
public interface ManufactureService {
    /**
     * xxxxxxxxxxx
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo selectAllManufacture(int page, int rows);

    /**
     * 添加生产计划
     * @param manufacture
     * @return QueryStatus
     */
    QueryStatus insert(Manufacture manufacture);

    /**
     * 修改 manufacture
     * @param manufacture
     * @return QueryStatus
     */
    QueryStatus updateByPrimaryKeySelective(Manufacture manufacture);

    /**
     * 批量删除manufacture
     * @param ids
     * @return
     */
    QueryStatus deleteBatch(String[] ids) throws ManufactureException;

    /**
     * 按生产批号查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchManufactureByManufactureSn(String searchValue, int page, int rows);

    /**
     * 按订单号查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchManufactureByManufactureOrderId(String searchValue, int page, int rows);

    /**
     * 按工艺查询
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchManufactureByManufactureTechnologyName(String searchValue, int page, int rows);
}
