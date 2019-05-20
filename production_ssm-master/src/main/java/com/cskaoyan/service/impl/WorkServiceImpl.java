package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.Process;
import com.cskaoyan.exception.WorkException;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class WorkServiceImpl implements WorkService {
    private WorkMapper workMapper;

    @Autowired
    public WorkServiceImpl(WorkMapper workMapper) {
        this.workMapper = workMapper;
    }


    @Override
    public BaseResultVo selectAllWork(int page, int rows) {
        BaseResultVo<Work> baseResultVo = new BaseResultVo<>();
        WorkExample workExample = new WorkExample();
        int total = (int) workMapper.countByExample(workExample);

        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Work> works = workMapper.selectAllWork(rows, offset);
        baseResultVo.setRows(works);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public QueryStatus insert(Work work) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = workMapper.insertSelective(work);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该作业编号已经存在，请更换作业编号！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus updateByPrimaryKeySelective(Work work) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = workMapper.updateByPrimaryKeySelective(work);
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
    public QueryStatus deleteBatch(String[] ids) throws WorkException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                workMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new WorkException("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    public BaseResultVo pageHandle(Work work,int rows,int page){
        BaseResultVo<Work> baseResultVo = new BaseResultVo<>();
        int total = workMapper.selectCountWorkByCondition(work);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Work> works = workMapper.searchWorkByCondition(work, rows, offset);
        //封装list和total
        baseResultVo.setRows(works);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchWorkById(String searchValue, int page, int rows) {
        Work work = new Work();
        Product product = new Product();
        Device device = new Device();
        Process process = new Process();
        work.setWorkId("%" + searchValue +"%");
        work.setProduct(product);
        work.setDevice(device);
        work.setProcess(process);
        return pageHandle(work,rows,page);
    }

    @Override
    public BaseResultVo searchWorkByProduct(String searchValue, int page, int rows) {
        Work work = new Work();
        Product product = new Product();
        Device device = new Device();
        Process process = new Process();
        product.setProductName("%" + searchValue +"%");

        work.setProduct(product);
        work.setDevice(device);
        work.setProcess(process);
        return pageHandle(work,rows,page);
    }

    @Override
    public BaseResultVo searchWorkByDevice(String searchValue, int page, int rows) {
        Work work = new Work();
        Product product = new Product();
        Device device = new Device();
        Process process = new Process();
        device.setDeviceName("%" + searchValue +"%");

        work.setProduct(product);
        work.setDevice(device);
        work.setProcess(process);
        return pageHandle(work,rows,page);
    }

    @Override
    public BaseResultVo searchWorkByProcess(String searchValue, int page, int rows) {
        Work work = new Work();
        Product product = new Product();
        Device device = new Device();
        Process process = new Process();
        process.setProcessId("%" + searchValue +"%");

        work.setProduct(product);
        work.setDevice(device);
        work.setProcess(process);
        return pageHandle(work,rows,page);
    }

    @Override
    public Work searchWorkDetail(String workId) {
        return workMapper.selectMultByPrimaryKey(workId);
    }

    @Override
    public List<Work> searchWorkList() {
        return workMapper.selectWork();
    }
}
