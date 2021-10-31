package com.audacioustux.model;

import java.util.*;

public class Blog {
    private UUID id;
    private Account account;
    private String title;
    private String body;

    public Blog(UUID id) {
        this.id = id;
    }

    public Blog(UUID id, Account account, String title, String body) {
        this(id);
        this.account = account;
        this.title = title;
        this.body = body;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
