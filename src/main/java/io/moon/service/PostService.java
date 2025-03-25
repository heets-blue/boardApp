package io.moon.service;

import io.moon.model.Board;
import io.moon.model.Post;
import io.moon.repository.BoardRepo;
import io.moon.repository.PostRepo;

public class PostService {
    PostRepo postRepo;
    BoardRepo boardRepo;

    public PostService(PostRepo postRepo, BoardRepo boardRepo) {
        this.postRepo = postRepo;
        this.boardRepo = boardRepo;
    }

    public Post addPost(String title, String body){
        return postRepo.addPost(title, body);
    }

    public void putPostInBoard(Board board, Post post){
        postRepo.putPostInBoard(board, post);
    }

}
