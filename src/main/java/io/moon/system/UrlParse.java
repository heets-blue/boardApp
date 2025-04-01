package io.moon.system;

import java.util.HashMap;

public class UrlParse {
    private String url;
    private String target;
    private String function;
    private HashMap<String, String> params;

    private boolean goodUrl = true;

    public UrlParse(String url){
        this.url = url;
        this.params = new HashMap<>();
    }

    //  /boards/add?파라=값 파라미터는 하나만 허용하겠음
    public void parse(String url){
        if(!url.startsWith("/")){
            wrongUrl();
        }

        String[] splitUrl = url.split("/"); //   ["","boards","add?파라=값"]
        if(splitUrl.length != 3){
            wrongUrl();
        }

        this.target = splitUrl[1];

        String paramUrl= splitUrl[2];     //      "add?파라=값"

        if(paramUrl.contains("?")){ //따로 분리해야할듯
           setParams(paramUrl);
        }else{
            this.function = paramUrl;
        }
    }


    private void setParams(String paramUrl){
        String[] splitParaUrl = paramUrl.split("\\?");
        if(splitParaUrl.length != 2){
            wrongUrl();
        }
        function = splitParaUrl[0];

        String[] paraKeyValue = splitParaUrl[1].split("=");
        if(paraKeyValue.length != 2){
            wrongUrl();
        }
        String paraKey = paraKeyValue[0];

        String paraValue = paraKeyValue[1];

        this.params.put(paraKey, paraValue);
    }

    private void wrongUrl(){
        goodUrl = false;
        throw new IllegalArgumentException("잘못 된 URL입니다.");
    }

    public String getEndPoint(){
        String[] splitUrl = url.split("\\?");
        return splitUrl[0];
    }

    public String getUrl() {
        return url;
    }

    public String getTarget() {
        return target;
    }

    public String getFunction() {
        return function;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public boolean isGoodUrl() {
        return goodUrl;
    }
}
