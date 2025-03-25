package io.moon.model;

import java.time.LocalDateTime;

public class Post {
    private int ID;
    private String title;
    private String body;
    //private String author;

    private String createdDateTime;
    private String updatedDateTime;

    private int postCnt = 0;

    public Post(int id,String title, String body) {
        this.ID = id;
        this.title = title;
        this.body = body;
        this.createdDateTime = LocalDateTime.now().toString();
        this.updatedDateTime = LocalDateTime.now().toString();
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public String getUpdatedDateTime() {
        return updatedDateTime;
    }
}
