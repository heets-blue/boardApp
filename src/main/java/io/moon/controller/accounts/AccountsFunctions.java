package io.moon.controller.accounts;

import io.moon.model.Account;
import io.moon.service.AccountsService;
import io.moon.system.Container;
import io.moon.system.ParamValidator;
import io.moon.system.Request;

import java.util.Scanner;

public class AccountsFunctions {
    private final Scanner input = new Scanner(System.in);
    private final AccountsService accountsService = Container.accountsService;
    private final Request request;
    private final ParamValidator validator;

    public AccountsFunctions(Request request) {
        this.request = request;
        this.validator = new ParamValidator(request);
    }

    public void signup(){
        validator.noNeedParam();

        System.out.println("=======회원가입=======");
        System.out.print("ID: ");
        String ID = input.nextLine().trim();
        System.out.print("Password: ");
        String password = input.nextLine().trim();
        System.out.print("UserName: ");
        String nickname = input.nextLine().trim();

        Account newAccount = accountsService.signUp(ID, password, nickname);

        System.out.printf("%s님 환영합니다.\n", newAccount.getNickname());
    }

    public void login() {
        validator.noNeedParam();

        accountsService.alreadyLoggedIn(request);

        System.out.print("ID: ");
        String ID = input.nextLine().trim();
        System.out.print("Password: ");
        String password = input.nextLine().trim();

        accountsService.login(request ,ID, password);

        System.out.println("로그인 성공");
    }

    public void logout(){
        validator.noNeedParam();

        accountsService.logout(request);
        System.out.println("로그아웃 되었습니다.");
    }

    //TODO
    private void wrongPassword(String ID, String password) {}
}
