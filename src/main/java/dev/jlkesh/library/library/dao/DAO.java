package dev.jlkesh.library.library.dao;

import org.postgresql.Driver;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T, ID> {
    private final ThreadLocal<Connection> connectionThreadLocal = ThreadLocal.withInitial(
            () -> {
                try {
                    DriverManager.registerDriver(new Driver());
                    return DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/jakartaee?currentSchema=library1",
                            "postgres",
                            "123"
                    );
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
    );

    protected abstract T save(T t);

    protected abstract T get(ID id);

    protected abstract boolean update(T t);

    protected abstract boolean delete(ID id);

    protected Connection getConnection() {
        return connectionThreadLocal.get();
    }
}
