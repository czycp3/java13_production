package com.tuixiaofei.dao;

import com.tuixiaofei.domain.QueryVo;
import com.tuixiaofei.domain.User;

import java.util.List;

/**
 * @Author: 頽小废
 * @Date: 2019/5/13 20:07
 * @Compony: http://www.tuixiaofei.com
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据ID删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据ID查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
