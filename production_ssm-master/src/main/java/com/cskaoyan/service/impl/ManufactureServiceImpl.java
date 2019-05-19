package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.ManufactureExample;
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
}
