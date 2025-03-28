package io.moon.controller.posts;

import io.moon.model.Board;
import io.moon.model.Post;
import io.moon.service.BoardsService;
import io.moon.service.PostService;
import io.moon.system.Container;
import io.moon.system.Request;
import io.moon.system.validation.ParamValidator;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PostsFunctions {
    private final Scanner input = new Scanner(System.in);
    private final PostService postService = Container.postService;
    private final BoardsService boardsService = Container.boardsService;
    private final ParamValidator validator;
    private final Request request;

    public PostsFunctions(Request request) {
        this.request = request;
        this.validator = new ParamValidator(request);
    }

    public void addPost(String paramKey) {
        validator.badPramKey(paramKey);

        Integer targetBoardId = request.paramsValueStringToInt("boardId");
        Board targetBoard = boardsService.getBoardById(targetBoardId);

        validator.badParamValue(targetBoard,targetBoardId);

        System.out.println(targetBoard.getTitle() + " 게시판에 새 게시글을 생성합니다.");
        System.out.print("게시글 이름: ");
        String newTitle = input.nextLine().trim();
        System.out.print("본문: ");
        String newBody = input.nextLine().trim();

        Post newPost = postService.addPost(newTitle, newBody, targetBoard);

        System.out.printf("%s게시판에 %s게시글이 게시되었습니다.\n"
                ,targetBoard.getTitle(),newPost.getTitle());

    }

    public void removePost(String paramKey) {
        validator.badPramKey(paramKey);

        Integer targetPostId = request.paramsValueStringToInt(paramKey);
        Post removePost = postService.getPostById(targetPostId);

        validator.badParamValue(removePost,targetPostId);

        int boardId = postService.findBoardId(removePost);
        postService.removePost(removePost, targetPostId);

        System.out.printf("%s게시판의 %s게시글이 삭제되었습니다.\n",
                boardId, targetPostId);
    }


    public void editPost(String paramKey) {
        validator.badPramKey(paramKey);

        Integer targetPostId = request.paramsValueStringToInt(paramKey);
        Post editPost = postService.getPostById(targetPostId);

        validator.badParamValue(editPost,targetPostId);

        String oldTitle = editPost.getTitle();
        System.out.printf("%s 게시글을 수정합니다.\n",oldTitle);
        System.out.printf("새 제목: ");
        String newPostTitle = input.nextLine().trim();
        System.out.println("\n현재 본문: " + editPost.getBody());
        System.out.printf("새 본문: ");
        String newPostBody = input.nextLine().trim();

        editPost.setTitle(newPostTitle);
        editPost.setBody(newPostBody);
        editPost.setUpdatedDateTime(LocalDateTime.now().toString());

        System.out.printf("\n%s 게시글이 %s 게시글으로 성공적으로 수정되었습니다.\n",oldTitle,editPost.getTitle());

    }

    public void viewPost(String paramKey) {
        validator.badPramKey(paramKey);

        Integer targetPostId = request.paramsValueStringToInt(paramKey);
        Post viewPost = postService.getPostById(targetPostId);

        validator.badParamValue(viewPost,targetPostId);

        System.out.println(viewPost);
    }

}
