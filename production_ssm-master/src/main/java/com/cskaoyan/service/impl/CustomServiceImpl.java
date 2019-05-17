package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.CustomException;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CZY
 */
@Service
public class CustomServiceImpl implements CustomService {
    private final CustomMapper customMapper;

    @Autowired
    public CustomServiceImpl(CustomMapper customMapper) {
        this.customMapper = customMapper;
    }

    @Override
    public Custom selectByPrimaryKey(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }

    @Override
    public List<Custom> selectAllCustom() {
        return customMapper.selectAllCustom();
    }

    @Override
    public QueryStatus insert(Custom record) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = customMapper.insertSelective(record);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该客户编号已经存在，请更换客户编号！");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus deleteBatch(String[] ids) throws CustomException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                customMapper.deleteByPrimaryKey(id);
            }
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new CustomException("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus updateByPrimaryKeySelective(Custom record) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = customMapper.updateByPrimaryKeySelective(record);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该客户编号已经存在，请更换客户编号！");
        }
        return queryStatus;
    }
}
