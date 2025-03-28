package io.moon.model;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Board {
    private int ID;
    private String title;
    private String description;
    private final String createdDateTime;
    private String updatedDateTime;
    private HashMap<Integer, Post> posts;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUpdatedDateTime(String updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
