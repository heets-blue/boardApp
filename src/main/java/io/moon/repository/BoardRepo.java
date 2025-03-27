package io.moon.repository;

import io.moon.model.Board;

import java.util.HashMap;
import java.util.NoSuchElementException;

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

    public boolean isEmptyBoards(){
        return boards.isEmpty();
    }

    public Board getBoardById(Integer boardID){
        return boards.get(boardID);
    }

    public void viewBoard(Board board){
        String details = String.format(
        "게시판 ID : %d\n게시판 이름 : %s\n게시판 설명 : %s\n작성일 : %s\n수정일 : %s",
        board.getID(), board.getTitle(), board.getDescription(),
                board.getCreatedDateTime(), board.getUpdatedDateTime());

        System.out.println(details);
    }

    public void listBoards(){
        for(Integer id : boards.keySet()){
            Board board = boards.get(id);
            viewBoard(board);
        }
    }

    public void removeBoard(Board board){
        boards.remove(board.getID());
    }

    public void hasPosts(Board board){
        if (board.getPosts().isEmpty()){
            String noPosts = String.format("""
                                %s 게시판에는 아직 게시글이 없습니다.""",
                    board.getTitle());
            System.out.println(noPosts);
        }
    }


}
