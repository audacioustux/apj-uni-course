package com.audacioustux.model;

import java.sql.*;
import java.util.*;
import com.audacioustux.DBConnection;
import com.password4j.Password;

public class Accounts {
    public static Account insert(String username, String email, String rawPassword) throws SQLException {
        try (DBConnection dbc = new DBConnection()) {
            String sql = "INSERT INTO accounts (username, email, hashed_password) VALUES (?,?,?)";

            try (PreparedStatement Ups = dbc.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                final String hashedPassword = Password.hash(rawPassword).addSalt(System.getenv("SECRET")).withArgon2()
                        .getResult();

                Ups.setString(1, username);
                Ups.setString(2, email);
                Ups.setString(3, hashedPassword);

                Ups.executeUpdate();

                try (ResultSet rs = Ups.getGeneratedKeys()) {
                    rs.next();
                    return new Account(UUID.fromString(rs.getString(1)), username, email);
                }
            }
        }
    }

    public static Account authenticate(String username, String rawPassword) throws SQLException {
        try (DBConnection dbc = new DBConnection()) {
            String sql = "SELECT * FROM accounts WHERE username=?";

            try (PreparedStatement ps = dbc.getConnection().prepareStatement(sql)) {
                ps.setString(1, username);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        if (Password.check(rawPassword, rs.getString("hashed_password"))
                                .addSalt(System.getenv("SECRET")).withArgon2()) {
                            UUID id = UUID.fromString(rs.getString("id"));
                            return new Account(id, rs.getString("username"), rs.getString("email"));
                        }
                        return null;
                    }
                    return null;
                }
            }
        }
    }

    public static Account load(Account account) throws SQLException {
        try (DBConnection dbc = new DBConnection()) {
            String sql = "SELECT * FROM accounts WHERE id=?";

            try (PreparedStatement ps = dbc.getConnection().prepareStatement(sql)) {
                ps.setObject(1, account.getId());

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Account(account.getId(), rs.getString("username"), rs.getString("email"));
                    }
                    return null;
                }
            }
        }
    }
}
