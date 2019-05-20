package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.ManufactureExample;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.ManufactureException;
import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class ManufactureServiceImpl implements ManufactureService {

    private ManufactureMapper manufactureMapper;

    @Autowired
    public ManufactureServiceImpl(ManufactureMapper manufactureMapper) {
        this.manufactureMapper = manufactureMapper;
    }

    @Override
    public BaseResultVo selectAllManufacture(int page, int rows) {
        BaseResultVo<Manufacture> baseResultVo = new BaseResultVo<>();
        ManufactureExample manufactureExample = new ManufactureExample();
        int total = (int) manufactureMapper.countByExample(manufactureExample);

        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Manufacture> manufactures = manufactureMapper.selectAllManufacture(rows, offset);
        baseResultVo.setRows(manufactures);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public QueryStatus insert(Manufacture manufacture) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = manufactureMapper.insertSelective(manufacture);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该生产计划编号已经存在，请更换生产计划编号！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus updateByPrimaryKeySelective(Manufacture manufacture) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = manufactureMapper.updateByPrimaryKeySelective(manufacture);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败！请重新尝试！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus deleteBatch(String[] ids) throws ManufactureException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                manufactureMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new ManufactureException("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }
}
