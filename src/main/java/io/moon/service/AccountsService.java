package io.moon.service;

import io.moon.model.Account;
import io.moon.repository.AccountsRepo;
import io.moon.system.Request;

import java.util.NoSuchElementException;

public class AccountsService {
    private AccountsRepo accountsRepo;

    public AccountsService(AccountsRepo accountsRepo) {
        this.accountsRepo = accountsRepo;
    }

    public Account signUp(String ID, String password, String nickname) {
        Account account = accountsRepo.signup(ID, password,nickname);
        if (account == null) {
            throw new IllegalArgumentException("이미 존재하는 ID 입니다.");
        }
        return account;

    }

    public void login(Request request, String ID, String password) {
        request.logIn(ID);

        hasAccount(ID);
        passwordCheck(ID, password);
    }

    public void logout(Request request) {
        if(!request.isLoggedIn()){
            throw new IllegalArgumentException("이미 로그아웃 상태입니다.");
        }
        request.logOut();
    }

    public Account hasAccount(String ID){
        Account findAccount = accountsRepo.getAccountById(ID);
        if(findAccount == null){
            throw new NoSuchElementException("해당 ID의 계정을 찾을 수 없습니다.");
        }
        return findAccount;
    }

    public void passwordCheck(String ID, String password){
        if(!accountsRepo.passwordCheck(ID, password)){
            throw new NoSuchElementException("비밀번호가 일치하지 않습니다.");
        }
    }

    public void alreadyLoggedIn(Request request) {
        if(request.isLoggedIn()){
            throw new RuntimeException("이미 로그인 되어있습니다.");
        }
    }

    public void detail(String accountId){
        Account account = hasAccount(accountId);
        System.out.println(account);
    }

    public void changePassword(String accountId, String newPassword){
        Account targetAccount = hasAccount(accountId);
        accountsRepo.changePassword(targetAccount, newPassword);
        System.out.println("비밀번호가 변경 되었습니다!");
    }

    public void removeAccount(String accountId, Request request){
        hasAccount(accountId);
        request.logOut();
        accountsRepo.removeAccount(accountId);
        System.out.printf("%s계정이 삭제 되었습니다.\n", accountId);
    }


}
