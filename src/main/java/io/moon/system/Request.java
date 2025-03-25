package io.moon.system;

import java.util.HashMap;

public class Request {
    private UrlParse urlParse;

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




}


