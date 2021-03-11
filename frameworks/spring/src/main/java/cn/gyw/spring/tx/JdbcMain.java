package cn.gyw.spring.tx;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcMain {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, "root", "Cc555555");
        System.out.println(connection);
    }
}
