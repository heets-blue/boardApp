package io.moon.model;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Board {
    private int ID;
    private String title;
    private String description;
    private String createdDateTime;
    private String updatedDateTime;
    private HashMap<Integer, Post> posts;

    private int boardCnt = 1;

    public Board(int id, String title, String description) {
        this.ID = id;
        this.title = title;
        this.description = description;
        this.posts = new HashMap<>();
        this.createdDateTime = LocalDateTime.now().toString();
        this.updatedDateTime = LocalDateTime.now().toString();
    }


    public void std() {
        String postsInBoard = ("글 번호 / 글 제목 / 작성일");
        System.out.println(postsInBoard);
        for (Post post : posts.values()) {
            System.out.println(post.getID() + "  /  "
            + post.getTitle() + "  /  "
            + post.getCreatedDateTime());
        }

    }



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public String getUpdatedDateTime() {
        return updatedDateTime;
    }

    public int getID() {
        return ID;
    }

    public HashMap<Integer, Post> getPosts() {
        return posts;
    }



}
