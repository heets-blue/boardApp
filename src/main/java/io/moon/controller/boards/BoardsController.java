package io.moon.controller.boards;

import io.moon.model.Board;
import io.moon.repository.BoardRepo;
import io.moon.service.BoardsService;
import io.moon.system.Container;
import io.moon.system.Request;
import io.moon.system.validation.BoardsParamValidator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BoardsController {

    public void requestHandle(Request request) {
        BoardsFunctions functions = new BoardsFunctions(request);
        try{
            switch (request.getFunction()){
                case "add":
                    functions.addBoards();
                    break;

                case "edit":
                    String paramForEdit = "boardId";
                    functions.editBaords(paramForEdit);
                    break;

                case "remove":
                    String paramForRemove = "boardId";
                    functions.removeBoards(paramForRemove);
                    break;

                case "view":
                    String viewBoardParam = "boardName";
                    functions.viewBoards(viewBoardParam);
                    break;

                case "list":
                    functions.listBoards();
                    break;

                default:
                    System.out.println("존재하지 않는 명령어입니다.");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
