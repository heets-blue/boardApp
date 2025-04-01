package io.moon.config;

import io.moon.model.AuthType;
import io.moon.repository.AccountsRepo;
import io.moon.repository.BoardRepo;

public class DataConstructor {
    private BoardRepo boardRepo;
    private AccountsRepo accountsRepo;

    public DataConstructor(BoardRepo boardRepo, AccountsRepo accountsRepo) {
        this.boardRepo = boardRepo;
        this.accountsRepo = accountsRepo;
        addAdmin();
        addBoard();
    }

    private void addAdmin(){
        accountsRepo.makeAdmin(
                "admin",
                "admin",
                "[System]Admin"
        );

        accountsRepo.makeAdmin(
                "yb9766",
                "admin",
                "[System]이예빈"
        );

    }

    private void addBoard(){
        boardRepo.addBoard("자유게시판", "자유게시판입니다.");
        boardRepo.addBoard("정치/사회 게시판", "이 곳에서 정치질을 하시면 됩니다.");
    }
}
