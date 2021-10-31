package by.itacademy.javaenterprise.goralchuk.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLSyntaxErrorException;
import java.util.ResourceBundle;

public class ConnectionToDataBase {
    private static final Logger logger = LoggerFactory.getLogger(ConnectionToDataBase.class);

    public static Connection getNewConnection() {
        String url = "jdbc:mariadb://127.0.0.1:10000/hospital";
        String userName = "root";
        String userPass = "root";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, userPass);
        } catch (SQLInvalidAuthorizationSpecException e) {
            logger.error("User data is not correct", e);
        } catch (SQLSyntaxErrorException e) {
            logger.error("Could not connect to address" + url, e);
        } catch (SQLException e) {
            logger.error("Found problem" + e);
        }
        return connection;
    }

    public static Connection getNewConnectionViaFile() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLInvalidAuthorizationSpecException e) {
            logger.error("User data is not correct", e);
        } catch (SQLSyntaxErrorException e) {
            logger.error("Could not connect to address" + url, e);
        } catch (SQLException e) {
            logger.error("Found problem" + e);
        }
        return connection;
    }



}
