package io.moon.system;

import io.moon.config.UrlAuthConfig;
import io.moon.model.Account;
import io.moon.model.AuthType;
import io.moon.model.UrlAuthType;
import io.moon.service.AccountsService;

import java.util.NoSuchElementException;

public class Filter {
    private AccountsService accountsService;
    private Request request;

    public Filter(Request request) {
        this.accountsService = Container.accountsService;
        this.request = request;
    }

    public boolean isValidAuth() {
        UrlAuthType authType = getUrlAuth();
        boolean isLogin = request.isLoggedIn();

        if (authType == UrlAuthType.ALL) {
            return true;
        }
        if (authType == UrlAuthType.NO_LOGIN ){
            return !isLogin;
        }
        if (!isLogin) {
            return false;

        }
        if (authType == UrlAuthType.LOGIN) {
            return true;
        }
        if (authType == UrlAuthType.ADMIN) {
            Account account = accountsService.hasAccount(request.getLoginedAccountId());
            return account.getAuthType() == AuthType.ADMIN;
        }
        return false;
    }

    public UrlAuthType getUrlAuth(){
        String url = request.getEndPoint();
        UrlAuthType authType = UrlAuthConfig.urlAuthTypeMap.get(url);
        if (authType == null) {
            return UrlAuthType.ALL;
        }
        return authType;
    }


}
