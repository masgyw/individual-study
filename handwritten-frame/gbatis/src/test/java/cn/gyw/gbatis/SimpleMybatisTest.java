package cn.gyw.gbatis;

import cn.gyw.gbatis.mapper.UserMapper;
import cn.gyw.gbatis.session.SqlSession;
import cn.gyw.gbatis.session.SqlSessionFactory;

import cn.gyw.gbatis.model.User;

import org.junit.Test;

import java.util.List;

/**
 * Created by guanyw on 2019/3/1.
 */
public class SimpleMybatisTest {

    @Test
    public void selectByMapperInterface() {
        // 1、实例化SqlSessionFactory，加载配置文件到Configuration 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        // 2、获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.queryAll();
        System.out.println("result >>" + userList);
    }

    @Test
    public void selectByTradition() {
        // 1、实例化SqlSessionFactory，加载配置文件到Configuration 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        // 2、获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.selectOne("cn.gyw.gbatis.mapper.UserMapper" + ".queryAll");

    }
}
