package com.audacioustux.model;

import java.sql.*;
import java.util.*;
import com.password4j.Password;

public class Accounts {
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    public static ArrayList<Account> getAll() throws SQLException {
        return accounts;
    }

    public static Account deleteById(UUID id) throws SQLException {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {
                return accounts.remove(i);
            }
        }
        return null;
    }

    public static Account insert(String username, String email, String rawPassword) throws SQLException {
        final String hashedPassword = Password.hash(rawPassword).addSalt(System.getenv("SECRET")).withArgon2()
                .getResult();
        Account account = new Account(UUID.randomUUID(), username, email, hashedPassword);
        accounts.add(account);
        return account;
    }

    public static Account authenticate(String username, String rawPassword) throws SQLException {
        Account account = null;
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                account = acc;
                break;
            }
        }
        if (account != null) {
            if (Password.check(rawPassword, account.getPassword()).addSalt(System.getenv("SECRET")).withArgon2()) {
                return account;
            }
            return null;
        }
        return null;
    }

    public static Account load(Account account) throws SQLException {
        for (Account acc : accounts) {
            if (acc.getId().equals(account.getId())) {
                return acc;
            }
        }
        return null;
    }

}
