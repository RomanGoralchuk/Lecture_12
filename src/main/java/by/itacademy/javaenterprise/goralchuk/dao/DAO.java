package by.itacademy.javaenterprise.goralchuk.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface DAO<T> {

    T get(Serializable id) throws SQLException;

    void save(T t);

    void update(T t) throws SQLException;

    int delete(Serializable id) throws SQLException;
}
