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
                    System.out.print("Enter board name: ");
                    break;

                case "view":
                    boolean param = request.hasParams("boardId");
                    if(!param){
                        throw new IllegalArgumentException("파라미터 입력이 잘못되었습니다.");
                    }

                    Board viewingBoard = boardsService.viewBoard(request.getParams().get("boardName"));
                    if (viewingBoard == null){
                        throw new NoSuchElementException("해당 번호의 게시판이 존재하지 않습니다.");
                    }

                    if (viewingBoard.getPosts().isEmpty()){
                        String noPosts = String.format("""
                                %s번 게시판에는 아직 게시글이 없습니다.""",
                                viewingBoard.getTitle());
                        throw new NoSuchElementException(noPosts);
                    }

                    viewingBoard.std();
                    break;



                default:
                    System.out.println("존재하지 않는 명령어입니다.");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
