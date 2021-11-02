package com.audacioustux.model;

import java.sql.*;
import java.util.*;
import com.audacioustux.DBConnection;

public class Comments {
    public static Comment insert(Account account, Blog blog, String body, Comment replied_to) throws SQLException {
        try (DBConnection dbc = new DBConnection()) {
            String sql = "INSERT INTO comments (account_id, blog_id, body, replied_to_id) VALUES (?,?,?,?)";

            try (PreparedStatement Ups = dbc.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                Ups.setObject(1, account.getId());
                Ups.setObject(2, blog.getId());
                Ups.setObject(3, body);
                if (replied_to == null)
                    Ups.setObject(4, null);
                else
                    Ups.setObject(4, replied_to.getId());

                Ups.executeUpdate();

                try (ResultSet rs = Ups.getGeneratedKeys()) {
                    rs.next();
                    return new Comment(UUID.fromString(rs.getString(1)), body, blog, account, replied_to);
                }
            }
        }
    }

    public static ArrayList<Comment> getByBlog(Blog blog) throws SQLException {
        try (DBConnection dbc = new DBConnection()) {
            String sql = "SELECT * FROM comments WHERE blog_id=?";

            try (PreparedStatement ps = dbc.getConnection().prepareStatement(sql)) {
                ps.setObject(1, blog.getId());

                try (ResultSet rs = ps.executeQuery()) {
                    ArrayList<Comment> comments = new ArrayList<Comment>();
                    while (rs.next()) {
                        String replied_to_id = rs.getString("replied_to_id");
                        Comment replied_to = null;
                        if (replied_to_id != null)
                            new Comment(UUID.fromString(replied_to_id));

                        comments.add(new Comment(UUID.fromString(rs.getString("id")), rs.getString("body"), blog,
                                new Account(UUID.fromString(rs.getString("account_id"))), replied_to));
                    }
                    return comments;
                }
            }
        }
    }
}
