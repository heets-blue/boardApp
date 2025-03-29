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
        }

    }
}
