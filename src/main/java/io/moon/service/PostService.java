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

    public Post getPostById(Integer postId) {
        return postRepo.getPostById(postId);
    }

    public Post addPost(String title, String body, Board board){
        return postRepo.addPost(title, body, board);
    }

    public void removePost(Post post,int postId) {
        postRepo.removePost(post ,postId);
    }

    public int findBoardId(Post post){
        return postRepo.findBoardId(post);
    }

}
