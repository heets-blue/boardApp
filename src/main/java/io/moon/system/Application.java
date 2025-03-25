package io.moon.system;

import io.moon.controller.BoardsController;

import java.util.Scanner;

public class Application {
    private final Scanner input = Container.input;
    private final String domain;
    private final String protocol;
    private boolean isRunning = true;

    public Application(String protocol,String domain) {
        this.domain = domain;
        this.protocol = protocol;
    }

    public void run() {
        while (isRunning) {
            try{
                String commandLine = protocol+"://"+domain;
                System.out.print(commandLine);
                String url = input.nextLine();

                if(url.equals(".exit")){
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;
                }

                UrlParse urlParse = new UrlParse(url);
                urlParse.parse(url);
                Request request = new Request(urlParse);

                switch (request.getTarget()){
                    case "boards":
                        Container.boardsController.requestHandle(request);
                        break;
                    case "posts":
                        Container.postsController.requestHandle(request);
                        break;

                    default:
                        System.out.println("존재하지 않는 명령어입니다.");
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

    }


}
