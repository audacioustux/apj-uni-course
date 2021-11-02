package com.audacioustux.model;

import java.sql.*;
import java.util.*;
import com.audacioustux.DBConnection;

public class Blogs {
    public static Blog insert(Account account, String title, String body) throws SQLException {
        try (DBConnection dbc = new DBConnection()) {
            String sql = "INSERT INTO blogs (account_id, title, body) VALUES (?,?,?)";

            try (PreparedStatement Ups = dbc.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                Ups.setObject(1, account.getId());
                Ups.setString(2, title);
                Ups.setString(3, body);

                Ups.executeUpdate();

                try (ResultSet rs = Ups.getGeneratedKeys()) {
                    rs.next();
                    return new Blog(UUID.fromString(rs.getString("id")), account, title, body);
                }
            }
        }
    }

    public static Blog get(UUID id) throws SQLException {
        try (DBConnection dbc = new DBConnection()) {
            String sql = "SELECT * FROM blogs WHERE id=?";

            try (PreparedStatement ps = dbc.getConnection().prepareStatement(sql)) {
                ps.setObject(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Blog(id, new Account(UUID.fromString(rs.getString("account_id"))),
                                rs.getString("title"), rs.getString("body"));
                    }
                    return null;
                }
            }
        }
    }

    public static ArrayList<Blog> getAll() throws SQLException {
        try (DBConnection dbc = new DBConnection()) {
            String sql = "SELECT * FROM blogs";

            try (PreparedStatement ps = dbc.getConnection().prepareStatement(sql)) {

                try (ResultSet rs = ps.executeQuery()) {
                    ArrayList<Blog> blogs = new ArrayList<Blog>();
                    while (rs.next()) {
                        blogs.add(new Blog(UUID.fromString(rs.getString("id")),
                                new Account(UUID.fromString(rs.getString("id"))), rs.getString("title"),
                                rs.getString("body")));
                    }
                    return blogs;
                }
            }
        }
    }
}
