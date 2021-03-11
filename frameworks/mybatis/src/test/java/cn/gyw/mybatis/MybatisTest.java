package cn.gyw.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.gyw.mybatis.mapper.UserMapper;
import cn.gyw.mybatis.model.MybatisUser;

public class MybatisTest {

    /**
     * Mapper 接口编程模型
     */
    @Test
    public void selectByIMapper() throws IOException {
        String resource = "mybatis-config.xml";
        // ============== 第一阶段=============
        // 1.读取Mybatis配置文件，创建SqlSessionFactory
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // ============== 第二阶段=============
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取对应的Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // ============== 第三阶段=============
        // 4.执行数据操作语句，获取执行结果
        List<MybatisUser> users = userMapper.queryAll();
//        System.out.println(users);

        MybatisUser user = users.get(0);

        reader.close();
        sqlSession.close();
    }

    /**
     * 传统的ibatis 编程模型
     *
     * @throws IOException
     */
    @Test
    public void selectByTradition() throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        // ============== 第一阶段=============
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<MybatisUser> userList = sqlSession.selectList("cn.gyw.mybatis.UserMapper.queryAll");
        sqlSession.close();

        System.out.println(userList);
    }

    @Test
    public void findByOneToOne() throws IOException {
        String resource = "mybatis-config.xml";
        // ============== 第一阶段=============
        // 1.读取Mybatis配置文件，创建SqlSessionFactory
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // ============== 第二阶段=============
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取对应的Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // ============== 第三阶段=============
        // 4.执行数据操作语句，获取执行结果
        List<Map<String, Object>> users = userMapper.findByOneToOne();
        Map<String, Object> data = users.get(0);
        System.out.println(data.get("firstName").getClass().getName());


        reader.close();
        sqlSession.close();
    }
}
