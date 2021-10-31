package by.itacademy.javaenterprise.goralchuk.DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    T get(Serializable id) throws SQLException;

    T create(T t) throws SQLException;

    void update(T t) throws SQLException;

    int delete(Serializable id) throws SQLException;
}
