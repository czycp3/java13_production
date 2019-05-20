package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.exception.ManufactureException;
import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
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

    public BaseResultVo pageHandle(Manufacture manufacture,int rows,int page){
        BaseResultVo<Manufacture> baseResultVo = new BaseResultVo<>();
        int total = manufactureMapper.selectCountOrderByCondition(manufacture);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Manufacture> orders = manufactureMapper.searchOrderByCondition(manufacture, rows, offset);
        //封装list和total
        baseResultVo.setRows(orders);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchManufactureByManufactureSn(String searchValue, int page, int rows) {
        Manufacture manufacture = new Manufacture();
        Order order = new Order();
        Technology technology = new Technology();

        manufacture.setManufactureSn("%" + searchValue +"%");
        manufacture.setcOrder(order);
        manufacture.setTechnology(technology);
        return pageHandle(manufacture,rows,page);
    }

    @Override
    public BaseResultVo searchManufactureByManufactureOrderId(String searchValue, int page, int rows) {
        Manufacture manufacture = new Manufacture();
        Order order = new Order();
        Technology technology = new Technology();

        order.setOrderId("%" + searchValue +"%");
        manufacture.setcOrder(order);
        manufacture.setTechnology(technology);
        return pageHandle(manufacture,rows,page);
    }

    @Override
    public BaseResultVo searchManufactureByManufactureTechnologyName(String searchValue, int page, int rows) {
        Manufacture manufacture = new Manufacture();
        Order order = new Order();
        Technology technology = new Technology();

        technology.setTechnologyName("%" + searchValue +"%");
        manufacture.setcOrder(order);
        manufacture.setTechnology(technology);
        return pageHandle(manufacture,rows,page);
    }

    @Override
    public Manufacture searchManufactureDetail(String manufactureId) {
        return manufactureMapper.selectByPrimaryKey(manufactureId);
    }

    @Override
    public List<Manufacture> searchManufactureList() {
        return manufactureMapper.selectManufacture();
    }
}
