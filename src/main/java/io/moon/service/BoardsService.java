package io.moon.service;

import io.moon.model.Board;
import io.moon.model.Post;
import io.moon.repository.BoardRepo;

public class BoardsService {

    BoardRepo boardRepo;

    public BoardsService(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }

    public int addBoard(String title, String description){
        return boardRepo.addBoard(title, description).getID();
    }

    public Board viewBoard(Integer boardID){
        return boardRepo.getBoardById(boardID);
    }

    public Board getBoardById(Integer boardID){
        return boardRepo.getBoardById(boardID);
    }




}
