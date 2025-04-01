package io.moon.model;

public enum UrlAuthType {
    NO_LOGIN, // 로그인을 하지 않아야만 접근 가능한 타입
    LOGIN, // 로그인을 하여야만 접근 가능한 타입
    ALL, // 로그인을 했건 안했건 접근 가능한 URL
    ADMIN // 로그인을 하고, 로그인 한 유저의 권한이 관리자
}
