package io.moon.repository;

import io.moon.model.Board;
import io.moon.model.Post;

import java.util.HashMap;
import java.util.Map;

public class BoardRepo {
    HashMap<Integer, Board> boards = new HashMap<>();
    private int boardId = 0;

    public Board addBoard(String title, String description){
        boardId++;
        Board newBoard = new Board(boardId , title, description);
        boards.put(newBoard.getID(), newBoard);
        return newBoard;
    }

    public Board getBoardByName(String boardName){
        for(Integer id : boards.keySet()){
            if(boards.get(id).getTitle().equals(boardName)){
                return boards.get(id);
            }
        }
        return null;
    }

    public Board getBoardById(Integer boardID){
        return boards.get(boardID);
    }



}
