package io.moon.repository;

import io.moon.model.Account;

import java.util.HashMap;

public class AccountsRepo { ;
    private final HashMap<String, Account> accounts = new HashMap<>();

    public Account signup(String ID, String password, String nickname) {
        if(getAccountById(ID) != null){
            return null;
        }
        Account account = new Account(ID, password, nickname);
        accounts.put(ID,account);
        return account;
    }

    public boolean login(String ID, String password) {
        Account account = getAccountById(ID);
        if (account.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public Account getAccountById(String ID) {
        return accounts.get(ID);
    }

    public Account getAccountByNickname(String nickname) {
        for(Account account : accounts.values()) {
            if(account.getNickname().equals(nickname)) {
                return account;
            }
        }
        return null;
    }

}
