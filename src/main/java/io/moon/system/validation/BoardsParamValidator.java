package io.moon.system.validation;

import io.moon.repository.BoardRepo;
import io.moon.service.BoardsService;
import io.moon.system.Container;
import io.moon.system.Request;

import java.util.NoSuchElementException;


public class BoardsParamValidator {
    private final Request request;
    private final BoardsService boardsService = Container.boardsService;
    private final BoardRepo boardRepo = Container.boardRepo;

    public BoardsParamValidator(Request request) {
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

    public void badParamValue(Object obj, Integer ID){
        if (obj == null){
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
}
