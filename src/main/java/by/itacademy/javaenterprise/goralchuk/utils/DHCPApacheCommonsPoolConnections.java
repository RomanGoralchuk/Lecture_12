package by.itacademy.javaenterprise.goralchuk.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.Connection;
import java.sql.SQLException;

public class DHCPApacheCommonsPoolConnections {

    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-context.xml");

    private static BasicDataSource ds = context.getBean("dataSource", BasicDataSource.class);

    private DHCPApacheCommonsPoolConnections() {}

    public static Connection getPoolConnection() throws SQLException {
        return ds.getConnection();
    }
}