package io.moon.system;

import java.util.HashMap;

public class Request {
    private UrlParse urlParse;
    private final String AUTH_STATUS_KEY_NAME = "login_status";

    public Request(UrlParse urlParse) {
        this.urlParse = urlParse;
    }

    public String getTarget() {
        return urlParse.getTarget();
    }

    public String getFunction() {
        return urlParse.getFunction();
    }

    public HashMap<String, String> getParams() {
        return urlParse.getParams();
    }

    public boolean isValid(){
        return urlParse.isGoodUrl();
    }

    public boolean validParams(String param) {
        return getParams().containsKey(param);
    }

    public boolean noParams(){
        return getParams().isEmpty();
    }

    public String getParamsValue(String paramKey) {
        return getParams().get(paramKey);
    }
    public int paramsValueStringToInt(String param) {
        return Integer.parseInt(getParamsValue(param));
    }

    public void setSessionAttribute(String key, String value) {
        Session session = Container.session;
        session.setAttribute(key, value);
    }

    public void removeSessionAttribute(String key) {
        Session session = Container.session;
        session.removeAttribute(key);
    }

    public void logIn(String ID) {
        setSessionAttribute(AUTH_STATUS_KEY_NAME, ID);
    }

    public void logOut() {
        removeSessionAttribute(AUTH_STATUS_KEY_NAME);
    }

    public boolean isLoggedIn() {
        Session session = Container.session;
        return session.hasAttribute(AUTH_STATUS_KEY_NAME);
    }

}


