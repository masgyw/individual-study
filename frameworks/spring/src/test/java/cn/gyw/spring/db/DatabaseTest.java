package cn.gyw.spring.db;

import javax.sql.DataSource;

import cn.gyw.spring.db.dao.MemberDao;
import cn.gyw.spring.db.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.gyw.spring.db.DBAutoRouteConfig;
import cn.gyw.spring.config.RootConfig;
import cn.gyw.spring.db.service.TxOperations;
import cn.gyw.spring.db.service.TxUserService;

/**
 * spring 事务测试
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DBAutoRouteConfig.class})
@Rollback(value = false) // 配置事务不自动回滚
// extends AbstractTransactionalJUnit4SpringContextTests
public class DatabaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TxUserService txUserService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TxOperations txOperations;

    @Autowired
    private MemberDao memberDao;

    /**
     * 数据源自动路由
     * 分库分表
     */
    @Test
    public void dataBaseAutoRoute() {
        this.memberDao.insert(null);
    }

    /**
     * 测试事务方式运行
     */
    @Test
    public void tx1() {
        txOperations.addRoleAndUser1();
    }

    @Test
    public void addAndGet() {
        txUserService.addUser();
        txUserService.findUsers();
    }

    @Test
    public void queryUsers() {
        txOperations.queryUsers();
    }

    @Test
    public void addUser() {
        txUserService.addUser();
    }

    @Test
    public void selectUser() {
        txUserService.findUsers();
    }

    @Test
    public void showJdbcTemplate() {
        System.out.println(jdbcTemplate);
    }

    @Test
    public void showDatasource() {
        System.out.println("datasource :" + dataSource);
        System.out.println(jdbcTemplate.getDataSource());
    }

}
