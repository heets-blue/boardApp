package io.moon.controller.boards;

import io.moon.system.Request;

public class BoardsController {

    public void requestHandle(Request request) {
        BoardsFunctions functions = new BoardsFunctions(request);

        switch (request.getFunction()){
            case "add":
                functions.addBoards();
                break;

            case "edit":
                String paramForEdit = "boardId";
                functions.editBoards(paramForEdit);
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
    }
}
