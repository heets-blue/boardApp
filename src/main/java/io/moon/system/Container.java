package io.moon.system;

import io.moon.controller.BoardsController;
import io.moon.controller.PostsController;
import io.moon.model.Board;
import io.moon.model.Post;
import io.moon.repository.BoardRepo;
import io.moon.repository.PostRepo;
import io.moon.service.BoardsService;
import io.moon.service.PostService;

import java.util.Scanner;

public class Container {
    public static Scanner input;

    public static BoardRepo boardRepo;
    public static PostRepo postRepo;

    public static BoardsService boardsService;
    public static PostService postService;

    public static BoardsController boardsController;
    public static PostsController postsController;
    static {
        input = new Scanner(System.in);

        boardRepo = new BoardRepo();
        postRepo = new PostRepo();

        boardsService = new BoardsService(boardRepo);
        postService = new PostService(postRepo, boardRepo);


        boardsController = new BoardsController(input, boardsService);
        postsController = new PostsController(input, boardsService, postService);

    }
}
