package com.audacioustux.model;

import java.util.*;

public class Session {
    private UUID id;
    private Account account;
    private Boolean is_deleted;

    public Session(UUID id) {
        this.id = id;
    }

    public Session(UUID id, Account account) {
        this(id);
        this.account = account;
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

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
