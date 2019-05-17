package com.cskaoyan.service;

import com.cskaoyan.bean.Custom;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public interface CustomService {
    Custom selectByPrimaryKey(String customId);
    List<Custom> selectAllCustom();
}
