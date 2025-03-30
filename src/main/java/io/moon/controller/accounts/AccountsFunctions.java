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

    public void detail(String paramKey){
        validator.badPramKey(paramKey);
        String ID = request.getParamsValue(paramKey);

        accountsService.detail(ID);
    }

    public void edit(String paramKey){
        validator.badPramKey(paramKey);

        String accountId = request.getParamsValue(paramKey);

        accountsService.hasAccount(accountId);

        try{
            System.out.print("현재 비밀번호 : ");
            String presentPassword = input.nextLine().trim();
            accountsService.passwordCheck(accountId, presentPassword);

            System.out.print("새 비밀번호: ");
            String newPassword = input.nextLine().trim();
            System.out.print("새 비밀번호 재확인");
            String confirmPassword = input.nextLine().trim();

            if(!newPassword.equals(confirmPassword)){
                throw new IllegalAccessException("새 비밀번호와 비밀번호 확인이 일치하지 않습니다. 다시 입력해 주세요.");
            }

            accountsService.changePassword(accountId,newPassword);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void remove(String paramKey){
        validator.badPramKey(paramKey);
        String ID = request.getParamsValue(paramKey);
        accountsService.removeAccount(ID, request);
    }

}
