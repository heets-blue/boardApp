package io.moon.repository;

import io.moon.model.Account;
import io.moon.model.AuthType;

import java.util.HashMap;

public class AccountsRepo { ;
    private final HashMap<String, Account> accounts = new HashMap<>();

    public Account signup(String ID, String password, String nickname) {
        if(getAccountById(ID) != null){
            return null;
        }
        Account account = new Account(ID, password, nickname, AuthType.MEMBER);
        accounts.put(ID,account);
        return account;
    }

    public Account makeAdmin(String ID, String password, String nickname) {
        if(getAccountById(ID) != null){
            return null;
        }
        Account account = new Account(ID, password, nickname, AuthType.ADMIN);
        accounts.put(ID,account);
        return account;
    }

    public boolean passwordCheck(String ID, String password) {
        Account account = getAccountById(ID);
        return account.getPassword().equals(password);
    }

    public Account getAccountById(String ID) {
        return accounts.get(ID);
    }


    public void changePassword(Account account, String newPassword){
        account.setPassword(newPassword);
    }

    public void removeAccount(String ID){
        accounts.remove(ID);
    }

}
