package com.audacioustux;

import java.sql.*;
import java.util.Properties;

public class DBConnection implements AutoCloseable {
    private static final String DATABASE_DRIVER = "org.postgresql.postgres";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    Connection connection;
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
            Class.forName(DATABASE_DRIVER);
            System.out.println("henlo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        connection = DriverManager.getConnection(DATABASE_URL, getProperties());
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
