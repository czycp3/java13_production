package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.TechnologyException;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.ProcessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    private ProcessMapper processMapper;

    public ProcessServiceImpl(ProcessMapper processMapper) {
        this.processMapper = processMapper;
    }

    @Override
    public List<Process> selectAllProcess(int page, int rows) {
        int offset = (page - 1) * rows;
        return processMapper.selectAllProcess(rows,offset);
    }

    @Override
    public int selectCountProcess() {
        return processMapper.selectCountProcess();
    }

    @Override
    public QueryStatus insert(Process record) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            processMapper.insert(record);

            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该工序编号已经存在，请更换工艺编号！");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus deleteBatch(String[] ids) throws TechnologyException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                processMapper.deleteByPrimaryKey(id);
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
    public QueryStatus updateAll(Process process) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            processMapper.updateAll(process);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (SQLException e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败,请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public BaseResultVo searchProcessByProcessId(String searchValue, int page, int rows) {
        BaseResultVo<Process> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        Process process = new Process();
        process.setProcessId("%" + searchValue +"%");
        int total = processMapper.selectCountProcessByCondition(process);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Process> technologys = processMapper.searchProcessByCondition(process, rows, offset);
//        logger.debug(technologys);
        //封装list和total
        baseResultVo.setRows(technologys);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchProcessByTechnologyPlanId(String searchValue, int page, int rows) {
        BaseResultVo<Process> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        Process technology = new Process();
        technology.setTechnologyPlanId("%" + searchValue +"%");
        int total = processMapper.selectCountProcessByCondition(technology);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Process> technologys = processMapper.searchProcessByCondition(technology, rows, offset);
        //封装list和total
        baseResultVo.setRows(technologys);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public List<Process> selectAll() {
        return processMapper.selectAll();
    }

    @Override
    public Process selectByProcessId(String processId) {
        return processMapper.selectByProcessId(processId);
    }
}
