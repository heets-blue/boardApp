package io.moon.controller.accounts;

import io.moon.system.Request;

public class AccountsController {
    public void requestHandle(Request request){
        AccountsFunctions functions = new AccountsFunctions(request);

        switch (request.getFunction()){
            case "signup":
                functions.signup();
                break;

            case "login":
                functions.login();
                break;

            case "logout":
                functions.logout();
                break;

            case "detail":
                String detailParam = "accountId";
                functions.detail(detailParam);
                break;

            case "edit":
                String editParam = "accountId";
                functions.edit(editParam);
                break;

            case "remove":
                String removeParam = "accountId";
                functions.remove(removeParam);
                break;
            default:
                System.out.println("존재하지 않는 명령어입니다.");
        }

    }
}
