package io.moon.controller.posts;

import io.moon.system.Request;

public class PostsController {
    public void requestHandle(Request request){
        PostsFunctions functions = new PostsFunctions(request);

        switch (request.getFunction()){
            case "add":
                String paramForAdd = "boardId";
                functions.addPost(paramForAdd);
                break;

            case "remove":
                String paramForRemove = "postId";
                functions.removePost(paramForRemove);
                break;

            case "edit":
                String paramForEdit = "postId";
                functions.editPost(paramForEdit);
                break;

            case "view":
                String paramForView = "postId";
                functions.viewPost(paramForView);
                break;
            default:
                System.out.println("존재하지 않는 명령어입니다.");
        }


    }


}
