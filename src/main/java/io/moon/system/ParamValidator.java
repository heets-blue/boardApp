package io.moon.system;

import io.moon.model.Account;
import io.moon.model.Board;
import io.moon.model.Post;
import io.moon.repository.BoardRepo;
import io.moon.service.BoardsService;

import java.util.NoSuchElementException;


public class ParamValidator {
    private final Request request;
    private final BoardsService boardsService = Container.boardsService;
    private final BoardRepo boardRepo = Container.boardRepo;

    public ParamValidator(Request request) {
        this.request = request;
    }

    public void noNeedParam(){
        boolean noNeedParam = request.noParams();
        if(!noNeedParam){
            throw new IllegalArgumentException("파라미터가 필요 없는 명령입니다.");
        }
    }

    public void badPramKey(String validParamKey){
        if(!request.validParams(validParamKey)){
            String errorMsg = String.format("해당 명령어의 올바른 파라미터키는 %s입니다.",validParamKey);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public void badParamValue(Board board, Integer ID){
        if (board == null){
            String errorMsg = String.format("%d번 게시판이 존재 하지 않습니다.", ID);
            throw new NoSuchElementException(errorMsg);
        }
    }

    public void badParamValue(Object obj, String Name){
        if (obj == null){
            String errorMsg = String.format("%s 게시판이 존재 하지 않습니다.", Name);
            throw new NoSuchElementException(errorMsg);
        }
    }

    public void badParamValue(Post post, Integer ID){
        if (post == null){
            String errorMsg = String.format("%d번 게시글이 존재 하지 않습니다.", ID);
            throw new NoSuchElementException(errorMsg);
        }
    }

}
