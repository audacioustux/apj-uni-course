package com.audacioustux.model;

import java.sql.*;
import java.util.*;
import com.audacioustux.DBConnection;

public class Sessions {
    public static Session insert(Account account) throws SQLException {
        try (DBConnection dbc = new DBConnection()) {
            String sql = "INSERT INTO sessions (account_id) VALUES (?)";

            try (PreparedStatement Ups = dbc.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                Ups.setObject(1, account.getId());

                Ups.executeUpdate();

                try (ResultSet rs = Ups.getGeneratedKeys()) {
                    rs.next();
                    return new Session(UUID.fromString(rs.getString(1)), account);
                }
            }
        }
    }
}
