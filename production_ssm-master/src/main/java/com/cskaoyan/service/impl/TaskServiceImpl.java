package com.cskaoyan.service.impl;

import com.cskaoyan.annotation.ProceedTime;
import com.cskaoyan.bean.*;
import com.cskaoyan.exception.TaskException;
import com.cskaoyan.mapper.TaskMapper;
import com.cskaoyan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class TaskServiceImpl implements TaskService {

    private TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }


    @Override
    @ProceedTime
    public BaseResultVo selectAllTask(int page, int rows) {
        BaseResultVo<Task> baseResultVo = new BaseResultVo<>();
        TaskExample taskExample = new TaskExample();
        int total = (int) taskMapper.countByExample(taskExample);

        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Task> tasks = taskMapper.selectAllTask(rows, offset);
        baseResultVo.setRows(tasks);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    @ProceedTime
    public QueryStatus insert(Task task) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = taskMapper.insertSelective(task);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该派工编号已经存在，请更换编号！");
        }
        return queryStatus;
    }

    @Override
    @ProceedTime
    public QueryStatus updateByPrimaryKeySelective(Task task) {

        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = taskMapper.updateByPrimaryKeySelective(task);
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
    @ProceedTime
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus deleteBatch(String[] ids) throws TaskException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                taskMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new TaskException("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    public BaseResultVo pageHandle(Task task,int rows,int page){
        BaseResultVo<Task> baseResultVo = new BaseResultVo<>();
        int total = taskMapper.selectCountTaskByCondition(task);

        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Task> tasks = taskMapper.searchTaskByCondition(task, rows, offset);
        //封装list和total
        baseResultVo.setRows(tasks);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    @ProceedTime
    public BaseResultVo searchTaskByTaskId(String searchValue, int page, int rows) {
        Task task = new Task();
        Work work = new Work();
        Manufacture manufacture = new Manufacture();
        task.setTaskId("%" + searchValue +"%");
        task.setWork(work);
        task.setManufacture(manufacture);
        return pageHandle(task,rows,page);
    }

    @Override
    @ProceedTime
    public BaseResultVo searchTaskByWorkId(String searchValue, int page, int rows) {
        Task task = new Task();
        Work work = new Work();
        Manufacture manufacture = new Manufacture();
        task.setWorkId("%" + searchValue +"%");

        task.setWork(work);
        task.setManufacture(manufacture);

        return pageHandle(task,rows,page);
    }

    @Override
    @ProceedTime
    public BaseResultVo searchTaskByManufactureSn(String searchValue, int page, int rows) {
        Task task = new Task();
        Work work = new Work();
        Manufacture manufacture = new Manufacture();

        task.setManufactureSn("%" + searchValue +"%");
        task.setWork(work);
        task.setManufacture(manufacture);
        return pageHandle(task,rows,page);
    }


}
