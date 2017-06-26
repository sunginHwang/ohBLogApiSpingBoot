package com.sungin.ohBlogApi.exception.exceptions;

/**
 * Created by hwangseong-in on 2017. 6. 26..
 */
public class BoardCategoryNotExistException extends RuntimeException{

    public BoardCategoryNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardCategoryNotExistException(String message) {
        super(message);
    }
}
