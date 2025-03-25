package io.moon.controller;

import io.moon.model.Board;
import io.moon.repository.BoardRepo;
import io.moon.service.BoardsService;
import io.moon.system.Container;
import io.moon.system.Request;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BoardsController {
    private final Scanner input;
    private final BoardRepo boardRepo = Container.boardRepo;
    private final BoardsService boardsService = Container.boardsService;

    public BoardsController(Scanner input, BoardsService boardsService) {
        this.input = input;
    }

    public void requestHandle(Request request) {
        try{
            switch (request.getFunction()){
                case "add":
                    if (!request.noParams()){
                        throw new IllegalArgumentException("파라미터가 필요 없는 명령입니다.");
                    }
                    System.out.println("새 게시판을 생성합니다.");
                    System.out.print("게시판 이름: ");
                    String boardTitle = input.nextLine().trim();
                    System.out.print("게시판 설명: ");
                    String boardDescription = input.nextLine().trim();
                    int newBoardId = boardsService.addBoard(boardTitle, boardDescription);
                    System.out.printf("%d번 게시판이 성공적으로 생성되었습니다.\n", newBoardId);
                    break;

                case "edit":
                    System.out.print("Enter board name: ");
                    break;

                case "remove":
                    String removeBoardParam = "boardId";
                    if(!request.validParams(removeBoardParam)){
                        throw new IllegalArgumentException("파라미터 입력이 잘못되었습니다.");
                    }
                    Integer removeBoardId = request.paramsValueStringToInt(removeBoardParam);
                    Board removeBoard = boardsService.getBoardById(removeBoardId);

                    if(removeBoard == null){
                        throw new NoSuchElementException("입력한 번호의 게시판이 존재하지 않습니다.");
                    }
                    String removeBoardTitle = removeBoard.getTitle();

                    System.out.println(removeBoardTitle + " 안의 모든 게시글이 함께 삭제 됩니다.");
                    System.out.printf("정말 삭제 하시겠습니까? [Y/N] : ");
                    String reallyRemove = input.nextLine().trim();

                    if(reallyRemove.equalsIgnoreCase("y")) {
                        boardsService.removeBoard(removeBoard);
                        System.out.println(removeBoardTitle+" 게시판이 삭제되었습니다.");
                    }

                    break;

                case "view":
                    String viewBoardParam = "boardName";

                    if(!request.validParams(viewBoardParam)){
                        throw new IllegalArgumentException("파라미터 입력이 잘못되었습니다.");
                    }

                    String viewingBoardName = request.getParamsValue(viewBoardParam);
                    Board viewingBoard = boardsService.getBoardByName(viewingBoardName);

                    if (viewingBoard == null){
                        String noBoard = String.format("%s 게시판을 찾을 수 없습니다.", viewingBoardName);
                        throw new NoSuchElementException(noBoard);
                    }

                    if (viewingBoard.getPosts().isEmpty()){
                        String noPosts = String.format("""
                                %s번 게시판에는 아직 게시글이 없습니다.""",
                                viewingBoard.getTitle());
                        throw new NoSuchElementException(noPosts);
                    }

                    viewingBoard.std();
                    break;

                case "list":
                    if (!request.noParams()){
                        throw new IllegalArgumentException("파라미터가 필요 없는 명령입니다.");
                    }

                    if(boardsService.isEmptyBoards()){
                        throw new NoSuchElementException("현재 게시판이 존재하지 않습니다.");
                    }
                    boardsService.listBoards();
                    break;

                default:
                    System.out.println("존재하지 않는 명령어입니다.");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
