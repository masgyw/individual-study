package cn.gyw.mybatis;

import cn.gyw.mybatis.mapper.PhoneMapper;
import cn.gyw.mybatis.model.Phone;
import cn.gyw.mybatis.util.SqlSessionUtil;
import tk.mybatis.mapper.entity.Example;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * tk.mybatis 通用mapper 解决修改字段问题
 */
public class TkMybatisTest {
	
	/**
	 * 二级缓存
	 */
	@Test
	public void secondCache() {
		SqlSession sqlSession2 = SqlSessionUtil.openSqlSession();
		SqlSession sqlSession1 = SqlSessionUtil.openSqlSession();
		
        PhoneMapper phoneMapper1 = sqlSession1.getMapper(PhoneMapper.class);
        PhoneMapper phoneMapper2 = sqlSession2.getMapper(PhoneMapper.class);
        
        Example example = new Example(Phone.class);
        example.createCriteria().andEqualTo("id", "2");
        
//        Phone phone1 = phoneMapper1.selectOneByExample(example);
        Phone phone1 = phoneMapper1.selectById(2);
        System.out.println("1>>" + phone1);
        
        // session2 更新了数据
//        Phone phone = new Phone();
//        phone.setName("iphone13");
//        phoneMapper2.updateByExampleSelective(phone, example);
//        SqlSessionUtil.closeSqlSession(sqlSession2);
        
        // session1 查询的是旧的数据
//        Phone phone2 = phoneMapper2.selectOneByExample(example);
        Phone phone2 = phoneMapper2.selectById(2);
        System.out.println("2>>" + phone2);
        
        SqlSessionUtil.closeSqlSession(sqlSession1);
        SqlSessionUtil.closeSqlSession(sqlSession2);
	}
	
	/**
	 * 并发访问
	 * 一级缓存存在脏读问题
	 */
	@Test
	public void firstCacheWithDirtyRead() {
		SqlSession sqlSession1 = SqlSessionUtil.openSqlSession();
		SqlSession sqlSession2 = SqlSessionUtil.openSqlSession();
		
        PhoneMapper phoneMapper1 = sqlSession1.getMapper(PhoneMapper.class);
        PhoneMapper phoneMapper2 = sqlSession2.getMapper(PhoneMapper.class);
        
        Example example = new Example(Phone.class);
        example.createCriteria().andEqualTo("id", "2");
        
        Phone phone1 = phoneMapper1.selectOneByExample(example);
        System.out.println("1>>" + phone1);
        // session2 更新了数据
        Phone phone = new Phone();
        phone.setName("iphone11");
        phoneMapper2.updateByExampleSelective(phone, example);
        
        // session1 查询的是旧的数据
        Phone phone2 = phoneMapper1.selectOneByExample(example);
        System.out.println("2>>" + phone2);
        
        SqlSessionUtil.closeSqlSession(sqlSession1);
        SqlSessionUtil.closeSqlSession(sqlSession2);
	}

	/**
	 * 一级缓存
	 */
	@Test
	public void selectOnePhoneByFirstCache() {
		SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        PhoneMapper phoneMapper = sqlSession.getMapper(PhoneMapper.class);
        
        Example example = new Example(Phone.class);
        example.createCriteria().andEqualTo("id", "2");
        
        Phone phone1 = phoneMapper.selectOneByExample(example);
        System.out.println("1>>" + phone1);
        
        // update 清空1级缓存
//        Phone phone = new Phone();
//        phone.setName(UUID.randomUUID().toString());
//        phoneMapper.updateByExampleSelective(phone, example);
        
        Phone phone2 = phoneMapper.selectOneByExample(example);
        System.out.println("2>>" + phone2);
	}
	
    @Test
    public void phoneList() {
        try {
            SqlSession sqlSession = SqlSessionUtil.openSqlSession();
            PhoneMapper phoneMapper = sqlSession.getMapper(PhoneMapper.class);
            List<Phone> phoneList = phoneMapper.selectAll();
            SqlSessionUtil.closeSqlSession(sqlSession);
            phoneList.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
