package by.itacademy.javaenterprise.goralchuk.connect;

import lombok.Data;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

@Data
public class ConnectionPool {

    private ConnectionPool(){};

    private static class SingletonHolder {
        private static BasicDataSource basicDataSource = new BasicDataSource();
    }

    public void setBasicDataSource(BasicDataSource basicDataSource) {
        SingletonHolder.basicDataSource = basicDataSource;
    }

    public static Connection getPoolConnection() throws SQLException {
        return SingletonHolder.basicDataSource.getConnection();
    }
}
