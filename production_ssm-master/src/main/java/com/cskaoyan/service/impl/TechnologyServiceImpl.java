package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.exception.TechnologyException;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.TechnologyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author cly
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyMapper technologyMapper;
    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    public TechnologyServiceImpl(TechnologyMapper technologyMapper){
        this.technologyMapper = technologyMapper;
    }

    @Override
    public List<Technology> selectAllTechnology(int page, int rows) {
        //查询technology总记录数
        int total = technologyMapper.selectCountTechnology();
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        return technologyMapper.selectAllTechnology(rows,offset);
    }

    @Override
    public int selectCountTechnology() {
        return technologyMapper.selectCountTechnology();
    }

    @Override
    public QueryStatus insert(Technology record) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            technologyMapper.insert(record);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该工艺编号已经存在，请更换工艺编号！");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus deleteBatch(String[] ids) throws TechnologyException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                technologyMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new TechnologyException("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus updateAll(Technology technology) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            technologyMapper.updateAll(technology);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (SQLException e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败,请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public BaseResultVo searchTechnologyById(String searchValue, int page, int rows) {
        BaseResultVo<Technology> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        Technology technology = new Technology();
        technology.setTechnologyId("%" + searchValue +"%");
        int total = technologyMapper.selectCountTechnologyByCondition(technology);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Technology> technologys = technologyMapper.searchTechnologyByCondition(technology, rows, offset);
        logger.debug(technologys);
        //封装list和total
        baseResultVo.setRows(technologys);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchTechnologyByName(String searchValue, int page, int rows) {
        BaseResultVo<Technology> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        Technology technology = new Technology();
        technology.setTechnologyName("%" + searchValue +"%");
        int total = technologyMapper.selectCountTechnologyByCondition(technology);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Technology> technologys = technologyMapper.searchTechnologyByCondition(technology, rows, offset);
        logger.debug(technologys);
        //封装list和total
        baseResultVo.setRows(technologys);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public List<Technology> selectByExample() {
        return technologyMapper.selectToTalTechnology();
    }

    @Override
    public Technology selectByTechnologyId(String technologyId) {
        return technologyMapper.selectByTechnologyId(technologyId);
    }

}
