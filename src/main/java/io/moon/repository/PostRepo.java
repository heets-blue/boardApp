package io.moon.repository;

import io.moon.model.Board;
import io.moon.model.Post;

public class PostRepo {
    private int postId = 0;
    public Post addPost(String title, String body){
        postId++;
        return new Post(postId,title, body);
    }

    public void putPostInBoard(Board board, Post post){
        board.getPosts().put(post.getID(), post);
    }
}
