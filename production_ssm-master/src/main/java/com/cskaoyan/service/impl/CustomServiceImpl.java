package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.CustomException;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import org.apache.log4j.Logger;
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
    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    public CustomServiceImpl(CustomMapper customMapper) {
        this.customMapper = customMapper;
    }

    @Override
    public Custom selectByPrimaryKey(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }

    @Override
    public List<Custom> selectAllCustom(int page,int rows) {
        //查询custom总记录数
        int total = customMapper.selectCountCustom();
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        return customMapper.selectAllCustom(rows,offset);
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

    @Override
    public int selectCountCustom() {
        return customMapper.selectCountCustom();
    }

    @Override
    public BaseResultVo searchCustomById(String searchValue, int page, int rows) {
        BaseResultVo<Custom> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        Custom custom = new Custom();
        //searchValue = "%" + searchValue +"%";
        custom.setCustomId("%" + searchValue +"%");
        int total = customMapper.selectCountCustomByCondition(custom);

        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Custom> customs = customMapper.searchCustomByCondition(custom, rows, offset);
        logger.debug(customs);
        //封装list和total
        baseResultVo.setRows(customs);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchCustomByName(String searchValue, int page, int rows) {
        BaseResultVo<Custom> baseResultVo = new BaseResultVo<>();
        //按条件查询总条目
        Custom custom = new Custom();
        custom.setCustomName("%" + searchValue +"%");
        int total = customMapper.selectCountCustomByCondition(custom);

        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Custom> customs = customMapper.searchCustomByCondition(custom, rows, offset);
        //封装list和total
        baseResultVo.setRows(customs);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }


}
