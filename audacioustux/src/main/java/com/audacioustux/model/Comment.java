package com.audacioustux.model;

import java.util.*;

public class Comment {
    private UUID id;
    private String body;
    private Blog blog;
    private Account account;
    private Comment replied_to;

    public Comment(UUID id) {
        this.id = id;
    }

    public Comment(UUID id, String body, Blog blog, Account account) {
        this(id);
        this.body = body;
        this.blog = blog;
        this.account = account;
    }

    public Comment(UUID id, String body, Blog blog, Account account, Comment replied_to) {
        this(id, body, blog, account);
        this.replied_to = replied_to;
    }

    public UUID getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Comment getReplied_to() {
        return replied_to;
    }

    public void setReplied_to(Comment replied_to) {
        this.replied_to = replied_to;
    }
}
