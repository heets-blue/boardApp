package io.moon.system;

import io.moon.config.DataConstructor;
import io.moon.controller.accounts.AccountsController;
import io.moon.controller.boards.BoardsController;
import io.moon.controller.posts.PostsController;
import io.moon.repository.AccountsRepo;
import io.moon.repository.BoardRepo;
import io.moon.repository.PostRepo;
import io.moon.service.AccountsService;
import io.moon.service.BoardsService;
import io.moon.service.PostService;

import java.util.Scanner;

public class Container {
    public static Scanner input;

    public static Session session;

    public static BoardRepo boardRepo;
    public static PostRepo postRepo;
    public static AccountsRepo accountsRepo;

    public static BoardsService boardsService;
    public static PostService postService;
    public static AccountsService accountsService;

    public static BoardsController boardsController;
    public static PostsController postsController;
    public static AccountsController accountsController;

    public static DataConstructor dataConstructor;

    static {
        input = new Scanner(System.in);

        session = new Session();

        boardRepo = new BoardRepo();
        postRepo = new PostRepo();
        accountsRepo = new AccountsRepo();

        boardsService = new BoardsService(boardRepo);
        postService = new PostService(postRepo, boardRepo);
        accountsService = new AccountsService(accountsRepo);

        boardsController = new BoardsController();
        postsController = new PostsController();
        accountsController = new AccountsController();

        dataConstructor = new DataConstructor(boardRepo, accountsRepo);
    }
}
