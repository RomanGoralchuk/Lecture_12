package by.itacademy.javaenterprise.goralchuk.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DHCPApacheCommons {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:mariadb://127.0.0.1:10000/hospital");
        ds.setUsername("root");
        ds.setPassword("root");

        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private DHCPApacheCommons(){ }

}