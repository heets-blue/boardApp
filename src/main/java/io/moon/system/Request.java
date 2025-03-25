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

    public HashMap<String, Integer> getParams() {
        return urlParse.getParams();
    }

    public boolean isValid(){
        return urlParse.isGoodUrl();
    }

    public boolean hasParams(String param) {
        return getParams().containsKey(param);
    }

    public Integer getParamsValue(String param) {
        return getParams().get(param);
    }
}


