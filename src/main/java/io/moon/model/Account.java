package io.moon.model;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Account {
    private String ID;
    private String password;
    private String nickname;
    private final String created_at;

    private final AuthType authType;
    private HashMap<Integer, Post> posts;

    public Account(String ID, String password, String nickname, AuthType authType) {
        this.ID = ID;
        this.password = password;
        this.nickname = nickname;
        this.authType = authType;
        this.created_at = LocalDateTime.now().toString();
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

    @Override
    public String toString() {
        String accountDetail = String.format("""
                [회원 정보]
                ID: %s
                password: %s
                nickname: %s
                created_at: %s""", ID, password, nickname, created_at);
        return accountDetail;
    }

    public AuthType getAuthType() {
        return authType;
    }


}
