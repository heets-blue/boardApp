package io.moon.model;

import java.util.HashMap;

public class Account {
    private String ID;
    private String password;
    private String nickname;

    private String name;
    private String email;

    private HashMap<Integer, Post> posts;

    public Account(String ID, String password, String nickname) {
        this.ID = ID;
        this.password = password;
        this.nickname = nickname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<Integer, Post> getPosts() {
        return posts;
    }

    public void setPosts(HashMap<Integer, Post> posts) {
        this.posts = posts;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
