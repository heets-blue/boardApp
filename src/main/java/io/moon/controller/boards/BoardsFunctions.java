package io.moon.controller.boards;

import io.moon.model.Board;
import io.moon.service.BoardsService;
import io.moon.system.Container;
import io.moon.system.Request;
import io.moon.system.ParamValidator;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BoardsFunctions {
    private final Scanner input = new Scanner(System.in);
    private final BoardsService boardsService = Container.boardsService;
    private final ParamValidator validator;
    private final Request request;

    public BoardsFunctions(Request request) {
        this.request = request;
        this.validator = new ParamValidator(request);
    }

    public void addBoards(){
        validator.noNeedParam();

        System.out.println("새 게시판을 생성합니다.");
        System.out.print("게시판 이름: ");
        String boardTitle = input.nextLine().trim();
        System.out.print("게시판 설명: ");
        String boardDescription = input.nextLine().trim();
        int newBoardId = boardsService.addBoard(boardTitle, boardDescription);
        System.out.printf("%d번 게시판이 성공적으로 생성되었습니다.\n", newBoardId);
    }

    public void editBoards(String paramKey){
        validator.badPramKey(paramKey);

        Integer editBoardId = request.paramsValueStringToInt(paramKey);
        Board editBoard = boardsService.getBoardById(editBoardId);

        validator.badParamValue(editBoard,editBoardId);

        String oldTitle = editBoard.getTitle();
        System.out.printf("%s 게시판을 수정합니다.\n",oldTitle);
        System.out.printf("새 제목: ");
        String newBoardTitle = input.nextLine().trim();
        System.out.println("\n현재 게시판 설명: " + editBoard.getDescription());
        System.out.printf("새 설명: ");
        String newBoardDesc = input.nextLine().trim();

        editBoard.setTitle(newBoardTitle);
        editBoard.setDescription(newBoardDesc);
        editBoard.setUpdatedDateTime(LocalDateTime.now().toString());

        System.out.printf("\n%s 게시판이 %s 게시판으로 성공적으로 수정되었습니다.\n",oldTitle,editBoard.getTitle());
    }

    public void removeBoards(String paramKey){
        validator.badPramKey(paramKey);

        Integer removeBoardId = request.paramsValueStringToInt(paramKey);
        Board removeBoard = boardsService.getBoardById(removeBoardId);

        validator.badParamValue(removeBoard,removeBoardId);

        String removeBoardTitle = removeBoard.getTitle();

        System.out.println(removeBoardTitle + " 안의 모든 게시글이 함께 삭제 됩니다.");
        System.out.printf("정말 삭제 하시겠습니까? [Y/N] : ");
        String reallyRemove = input.nextLine().trim();

        if(reallyRemove.equalsIgnoreCase("y")) {
            boardsService.removeBoard(removeBoard);
            System.out.println(removeBoardTitle+" 게시판이 삭제되었습니다.");
        }
    }

    public void viewBoards(String paramKey){
        validator.badPramKey(paramKey);

        String viewBoardName = request.getParamsValue(paramKey);
        Board viewBoard = boardsService.getBoardByName(viewBoardName);

        validator.badParamValue(viewBoard,viewBoardName);

        boardsService.hasPosts(viewBoard);

        System.out.print("게시판 정보도 함께 조회하시겠습니까? [Y/N] : ");
        String viewTheBoard = input.nextLine().trim();
        if(viewTheBoard.equalsIgnoreCase("y")) {
            boardsService.viewBoard(viewBoard);
        }

        viewBoard.std();
    }

    public void listBoards(){
        validator.noNeedParam();

        if(boardsService.isEmptyBoards()){
            throw new NoSuchElementException("현재 게시판이 존재하지 않습니다.");
        }
        boardsService.listBoards();
    }
}
