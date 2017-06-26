package com.sungin.ohBlogApi.exception.exceptions;

/**
 * Created by hwangseong-in on 2017. 6. 14..
 */
public class BoardNotFoundException extends RuntimeException {

    public BoardNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardNotFoundException(String message) {
        super(message);
    }
}
