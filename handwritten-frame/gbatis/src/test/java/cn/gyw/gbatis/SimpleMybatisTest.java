package cn.gyw.gbatis;

import cn.gyw.gbatis.mapper.PersonMapper;
import cn.gyw.gbatis.session.SqlSession;
import cn.gyw.gbatis.session.SqlSessionFactory;

import cn.gyw.gbatis.model.Person;

import org.junit.Test;

import java.util.List;

public class SimpleMybatisTest {

    @Test
    public void selectByMapperInterface() {
        // 1、实例化SqlSessionFactory，加载配置文件到Configuration 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        // 2、获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> personList = personMapper.queryAll();
        System.out.println("result >>" + personList);
    }

}
