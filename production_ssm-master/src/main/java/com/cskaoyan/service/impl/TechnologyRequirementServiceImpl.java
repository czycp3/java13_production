package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.mapper.TechnologyRequirementMapper;
import com.cskaoyan.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
    TechnologyRequirementMapper technologyRequirementMapper;

    public TechnologyRequirementServiceImpl(TechnologyRequirementMapper technologyRequirementMapper) {
        this.technologyRequirementMapper = technologyRequirementMapper;
    }

    @Override
    public List<TechnologyRequirement> selectAllTechnologyRequirement(int page, int rows) {
        int offset = (page - 1) * rows;
        return technologyRequirementMapper.selectAllTechnologyRequirement(rows,offset);
    }

    @Override
    public int selectCountTechnologyRequirement() {
        return technologyRequirementMapper.selectCountTechnologyRequirement();
    }

    @Override
    public QueryStatus insert(TechnologyRequirement technologyRequirement) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            technologyRequirementMapper.insert(technologyRequirement);
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("该工艺要求编号已存在，请更换编号！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus deleteBatch(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                technologyRequirementMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus updateAll(TechnologyRequirement technologyRequirement) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            technologyRequirementMapper.updateAllByTechnologyRequirementId(technologyRequirement);
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        } catch (SQLException e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重新操作！");
        }
        return queryStatus;
    }

    @Override
    public BaseResultVo searchTechnologyRequirementById(String searchValue, int page, int rows) {
        BaseResultVo<TechnologyRequirement> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        TechnologyRequirement technologyRequirement = new TechnologyRequirement();
        technologyRequirement.setTechnologyRequirementId("%" + searchValue +"%");
        int total = technologyRequirementMapper.selectCountTechnologyRequirementByCondition(technologyRequirement);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.searchTechnologyRequirementByCondition(technologyRequirement, rows, offset);
        //封装list和total
        baseResultVo.setRows(technologyRequirements);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchTechnologyRequirementByName(String searchValue, int page, int rows) {
        BaseResultVo<TechnologyRequirement> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        TechnologyRequirement technologyRequirement = new TechnologyRequirement();
        technologyRequirement.setTechnologyName("%" + searchValue +"%");
        int total = technologyRequirementMapper.selectCountTechnologyRequirementByCondition(technologyRequirement);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.searchTechnologyRequirementByCondition(technologyRequirement, rows, offset);
        //封装list和total
        baseResultVo.setRows(technologyRequirements);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public QueryStatus updateRequirementById(TechnologyRequirement technologyRequirement) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            technologyRequirementMapper.updateRequirementById(technologyRequirement);
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        } catch (SQLException e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重新尝试！");
        }
        return queryStatus;
    }
}
