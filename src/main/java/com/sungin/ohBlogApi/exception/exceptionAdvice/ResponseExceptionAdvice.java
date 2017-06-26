package com.sungin.ohBlogApi.exception.exceptionAdvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

import com.sungin.ohBlogApi.exception.exceptions.*;

/**
 * Created by hwangseong-in on 2017. 6. 14..
 */
@ControllerAdvice
public class ResponseExceptionAdvice {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BoardNotFoundException.class)
    @ResponseBody ErrorInfo
    EmptyBoardContent(HttpServletRequest req, BoardNotFoundException ex) {
         return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BoardCategoryNotExistException.class)
    @ResponseBody ErrorInfo
    NotExistBoardCategory(HttpServletRequest req, BoardCategoryNotExistException ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BoardListNotFoundException.class)
    @ResponseBody ErrorInfo
    EmptyBoardList(HttpServletRequest req, BoardListNotFoundException ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BoardVaildException.class)
    @ResponseBody ErrorInfo
    FailBoardValidation(HttpServletRequest req, BoardVaildException ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BoardDeleteFailException.class)
    @ResponseBody ErrorInfo
    FailBoardDelete(HttpServletRequest req, BoardDeleteFailException ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }



}
