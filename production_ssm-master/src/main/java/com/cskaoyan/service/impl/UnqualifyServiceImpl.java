package com.cskaoyan.service.impl;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Unqualify;
import com.cskaoyan.mapper.UnqualifyMapper;
import com.cskaoyan.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-17 23:46
 */

@Service
public class UnqualifyServiceImpl implements UnqualifyService {

    @Autowired
    UnqualifyMapper unqualifyMapper;

    //分页查询不合格品列表
    @Override
    public List<Unqualify> findList(int rows, int offset) {
        List<Unqualify> unqualifyList = unqualifyMapper.findList(rows, offset);
        return unqualifyList;
    }

    @Override
    public List<Unqualify> findAllList() {
        List<Unqualify> unqualifyList = unqualifyMapper.findAllList();
        return unqualifyList;
    }

    @Override
    public QueryStatus insert(Unqualify unqualify) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = unqualifyMapper.insert(unqualify);
            if (i == 1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            } else {
                queryStatus.setStatus(404);
                queryStatus.setMsg("插入失败");
            }
      }catch (Exception e){
            queryStatus.setStatus(404);
            queryStatus.setMsg("不合格品申请编号重复，请重新申请");
        }
        return queryStatus;
    }

}
