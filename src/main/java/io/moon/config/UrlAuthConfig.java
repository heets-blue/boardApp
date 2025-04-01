package io.moon.config;

import io.moon.model.UrlAuthType;

import java.util.HashMap;
import java.util.Map;

public class UrlAuthConfig {

    public static final Map<String, UrlAuthType> urlAuthTypeMap;


    static {
        urlAuthTypeMap = Map.ofEntries(
                Map.entry("/accounts/login", UrlAuthType.NO_LOGIN),
                Map.entry("/accounts/signup", UrlAuthType.NO_LOGIN),
                Map.entry("/boards/add", UrlAuthType.ADMIN),
                Map.entry("/boards/edit",UrlAuthType.ADMIN),
                Map.entry("/boards/remove",UrlAuthType.ADMIN),
                Map.entry("/posts/add",UrlAuthType.LOGIN),
                Map.entry("/posts/edit",UrlAuthType.LOGIN),
                Map.entry("/posts/remove",UrlAuthType.LOGIN),
                Map.entry("/accounts/edit",UrlAuthType.LOGIN),
                Map.entry("/accounts/remove",UrlAuthType.LOGIN),
                Map.entry("/accounts/logout",UrlAuthType.LOGIN)
        );


    }

}
