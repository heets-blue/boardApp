package io.moon.controller;

import io.moon.model.Board;
import io.moon.model.Post;
import io.moon.service.BoardsService;
import io.moon.service.PostService;
import io.moon.system.Container;
import io.moon.system.Request;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PostsController {
    private Scanner input;
    private BoardsService boardsService;
    private PostService postService;

    public PostsController(Scanner input, BoardsService boardsService, PostService postService) {
        this.input = input;
        this.boardsService = boardsService;
        this.postService = postService;
    }

    public void requestHandle(Request request){
        try{
            switch (request.getFunction()){
                case "add":
                    boolean hasParams = request.hasParams("boardId");
                    if(!hasParams){
                        throw new IllegalArgumentException("파라미터 입력이 잘못되었습니다.");
                    }

                    Integer tergetBoardId = request.getParamsValue("boardId");
                    Board targetBoard = boardsService.getBoardById(tergetBoardId);
                    if(targetBoard == null){
                        throw new NoSuchElementException("입력한 번호의 게시판이 존재하지 않습니다.");
                    }

                    System.out.println(targetBoard.getTitle() + " 게시판에 새 게시글을 생성합니다.");
                    System.out.print("게시글 이름: ");
                    String newTitle = input.nextLine().trim();
                    System.out.print("본문: ");
                    String newBody = input.nextLine().trim();

                    Post newPost = postService.addPost(newTitle, newBody);
                    postService.putPostInBoard(targetBoard, newPost);

                    System.out.printf("%s게시판에 %s게시글이 게시되었습니다.\n"
                            ,targetBoard.getTitle(),newTitle);
                    break;

                default:
                    System.out.println("존재하지 않는 명령어입니다.");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
