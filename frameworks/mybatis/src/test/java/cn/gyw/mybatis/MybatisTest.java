package cn.gyw.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.gyw.mybatis.mapper.PhoneMapper;
import cn.gyw.mybatis.model.Phone;

public class MybatisTest {

	private String resource = "mybatis-config.xml"; 
	
	/**
	 * Mapper 接口编程模型
	 */
	@Test
	public void selectByIMapper() throws IOException {
		// ============== 第一阶段=============
		// 1.读取Mybatis配置文件，创建SqlSessionFactory
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		// ============== 第二阶段=============
		// 2.获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 3.获取对应的Mapper
		PhoneMapper userMapper = sqlSession.getMapper(PhoneMapper.class);

		// ============== 第三阶段=============
		// 4.执行数据操作语句，获取执行结果
		List<Phone> phoneList = userMapper.queryAll();
		phoneList.stream().forEach(System.out::println);

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
		Reader reader = Resources.getResourceAsReader(resource);
		// ============== 第一阶段=============
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<Phone> userList = sqlSession.selectList("cn.gyw.mybatis.mapper.PhoneMapper.queryAll");
		sqlSession.close();

		System.out.println(userList);
	}

	/**
	 * 1 - 1
	 * @throws IOException
	 */
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
		PhoneMapper userMapper = sqlSession.getMapper(PhoneMapper.class);

		// ============== 第三阶段=============
		// 4.执行数据操作语句，获取执行结果
		List<Map<String, Object>> users = userMapper.findByOneToOne();
		Map<String, Object> data = users.get(0);
		System.out.println(data.get("firstName").getClass().getName());

		reader.close();
		sqlSession.close();
	}
	
	/**
	 * 数据插入
	 * @throws Exception 
	 */
	@Test
	public void insertPhone() throws Exception {
		Phone phone = new Phone();
		phone.setName("iphone10");
		phone.setDesc("this is clob");
		phone.setImage("this is image".getBytes());
		phone.setCreatedTime(LocalDateTime.now());
		phone.setPrice(9999.99);
		phone.setProducedDate(LocalDate.of(2021, 11, 11));
		
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		PhoneMapper phoneMapper = sqlSession.getMapper(PhoneMapper.class);
		
		phoneMapper.insert(phone);
		
		sqlSession.commit();
	}
}
