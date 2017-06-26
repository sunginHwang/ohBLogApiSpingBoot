package com.sungin.ohBlogApi.exception.exceptionAdvice;

/**
 * Created by hwangseong-in on 2017. 6. 14..
 */
public class ErrorInfo {
    public final String url;
    public final String message;


    public ErrorInfo(String url, String message) {
        this.url = url;
        this.message = message;
    }

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.message = ex.getLocalizedMessage();
    }


}
