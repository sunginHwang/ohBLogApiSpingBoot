package com.sungin.ohBlogApi.exception.exceptions;

/**
 * Created by hwangseong-in on 2017. 6. 26..
 */
public class BoardVaildException extends RuntimeException {

    public BoardVaildException(String message) {
        super(message);
    }

    public BoardVaildException(String message, Throwable cause) {
        super(message, cause);
    }
}
