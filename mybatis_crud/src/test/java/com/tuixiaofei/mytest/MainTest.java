package com.tuixiaofei.mytest;

import com.tuixiaofei.dao.IUserDao;
import com.tuixiaofei.domain.QueryVo;
import com.tuixiaofei.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author: 頽小废
 * @Date: 2019/5/13 20:13
 * @Compony: http://www.tuixiaofei.com
 */
public class MainTest{
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init () throws Exception{
        //1、读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception{
        //6、释放资源
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {

        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("mybatis Test insertId");
        user.setUserAddress("北京市东城区");
        user.setUserSex("女");
        user.setUserBirthday(new Date());
        System.out.println("保存操作之前："+user);
        //执行保存方法
        userDao.saveUser(user);

        System.out.println("保存操作之后："+user);

    }

    /**
     * 测试更新操作
     *
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserId(51);
        user.setUserName("mybatis Update user");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

        //执行保存方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){

        //执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * 测试查询操作
     */
    @Test
    public void testFindById(){

        //执行单个查询方法
        User user = userDao.findById(49);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     *
     */
    @Test
    public void testFindByName(){
        //List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数操作
     */
    @Test
    public void testTotal(){

        //执行查询总记录条数方法
        int total = userDao.findTotal();
        System.out.println(total - 1);

    }

    /**
     * 测试使用QueryVo作为条件查询
     *
     */
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        vo.setUser(user);
        user.setUserName("%王%");
        //List<User> users = userDao.findByName("%王%");
        List<User> userByVo = userDao.findUserByVo(vo);
        for (User user1 : userByVo) {
            System.out.println(user1);
        }

    }
}

