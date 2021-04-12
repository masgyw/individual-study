package cn.gyw.mybatis;

import cn.gyw.mybatis.mapper.PhoneMapper;
import cn.gyw.mybatis.model.Phone;
import cn.gyw.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * tk.mybatis 通用mapper 解决修改字段问题
 */
public class TkMybatisTest {

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
