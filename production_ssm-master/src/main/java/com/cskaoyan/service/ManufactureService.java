package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;

/**
 * @author CZY-Y7000P
 */
public interface ManufactureService {
    /**
     * xxxxxxxxxxx
     * @param page
     * @param rows
     * @return
     */
    BaseResultVo selectAllManufacture(int page, int rows);
}
