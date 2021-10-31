package com.audacioustux;

import java.sql.*;
import java.util.Properties;

public class DBConnection implements AutoCloseable {
    private static final String DRIVER = System.getenv("DATABASE_DRIVER");
    private static final String URL = System.getenv("DATABASE_URL");
    private static final String USERNAME = System.getenv("DATABASE_USERNAME");
    private static final String PASSWORD = System.getenv("DATABASE_PASSWORD");

    private Connection connection;
    private static Properties properties;

    private static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    public DBConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        connection = DriverManager.getConnection(URL, getProperties());
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }
}
