package io.moon.model;

import java.time.LocalDateTime;

public class Post {
    private int ID;
    private String title;
    private String body;
    //private String author;
    private Board board;
    private String createdDateTime;
    private String updatedDateTime;



    public Post(int id,String title, String body, Board board) {
        this.ID = id;
        this.title = title;
        this.body = body;
        this.createdDateTime = LocalDateTime.now().toString();
        this.updatedDateTime = LocalDateTime.now().toString();
        this.board = board;
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

    public Board getBoard() {
        return board;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setUpdatedDateTime(String updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    @Override
    public String toString() {
        return String.format("""
                
                제목 : %s
                본문 : %s
                게시판 : %s
                생성시각 : %s
                수정시각 : %s
                """,getTitle(),getBody(),getBoard().getTitle()
                ,getCreatedDateTime(),getUpdatedDateTime());
    }
}
