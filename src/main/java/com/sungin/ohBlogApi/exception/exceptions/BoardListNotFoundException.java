package com.sungin.ohBlogApi.exception.exceptions;

/**
 * Created by hwangseong-in on 2017. 6. 26..
 */
public class BoardListNotFoundException extends RuntimeException {

    public BoardListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardListNotFoundException(String message) {
        super(message);
    }
}
