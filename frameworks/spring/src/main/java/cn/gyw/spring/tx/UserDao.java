package cn.gyw.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert() {
        return jdbcTemplate.update("insert into user(oId, name, age) values (?,?,?)", (preparedStatement) -> {
            preparedStatement.setString(1, "1001");
            preparedStatement.setString(2, "xiaoming");
            preparedStatement.setInt(3, 29);
        });
    }

}
