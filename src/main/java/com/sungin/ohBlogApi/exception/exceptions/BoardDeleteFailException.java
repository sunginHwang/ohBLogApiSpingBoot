package com.sungin.ohBlogApi.exception.exceptions;

/**
 * Created by hwangseong-in on 2017. 6. 26..
 */
public class BoardDeleteFailException extends RuntimeException{
    public BoardDeleteFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardDeleteFailException(String message) {
        super(message);
    }
}
