package io.moon.repository;

import io.moon.model.Board;
import io.moon.model.Post;

import java.util.HashMap;

public class PostRepo {
    private int postId = 0;
    private HashMap<Integer, Post> posts = new HashMap<>();

    public Post getPostById(Integer postId) {
        return posts.get(postId);
    }

    public Post addPost(String title, String body, Board board){
        postId++;
        Post newPost = new Post(postId,title, body, board);
        board.getPosts().put(postId, newPost);
        posts.put(postId, newPost);
        return newPost;
    }

    public void putPostInBoard(Board board, Post post){
        board.getPosts().put(post.getID(), post);
    }

    public void removePost(Post post,int postId){
        posts.remove(postId);
        post.getBoard().getPosts().remove(postId);
    }

    public int findBoardId(Post post){
        return post.getBoard().getID();
    }
}
