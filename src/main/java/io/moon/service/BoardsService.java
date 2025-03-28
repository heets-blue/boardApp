package io.moon.service;

import io.moon.model.Board;
import io.moon.repository.BoardRepo;

public class BoardsService {

    BoardRepo boardRepo;

    public BoardsService(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }

    public int addBoard(String title, String description){
        return boardRepo.addBoard(title, description).getID();
    }

    public boolean isEmptyBoards(){
        return boardRepo.isEmptyBoards();
    }
    public Board getBoardByName(String boardName){
        return boardRepo.getBoardByName(boardName);
    }

    public Board getBoardById(Integer boardID){
        return boardRepo.getBoardById(boardID);
    }

    public void viewBoard(Board board){
        boardRepo.viewBoard(board);
    }

    public void listBoards(){
        boardRepo.listBoards();
    }

    public void removeBoard(Board board){
        boardRepo.removeBoard(board);
    }

    public void hasPosts(Board board){
        boardRepo.hasPosts(board);
    }

}
