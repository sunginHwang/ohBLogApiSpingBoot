package com.sungin.ohBlogApi.service.impl;

import com.sungin.ohBlogApi.exception.ExceptionMessage;
import com.sungin.ohBlogApi.exception.exceptions.*;
import com.sungin.ohBlogApi.service.BlogBoardService;
import com.sungin.ohBlogApi.dao.BlogBoardMapper;
import com.sungin.ohBlogApi.vo.BoardCommentVO;
import com.sungin.ohBlogApi.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 6. 4..
 */
@Service(value = "blogBoardService")
public class BlogBoardServiceImpl implements BlogBoardService {

    @Autowired
    private BlogBoardMapper blogBoardMapper;

    @Override
    public List<BoardVO> getBoardList(BoardVO boardVo) {

        isActivateCategory(boardVo.getCategoryKey());

        boardVo.setLimit(increaseLimitCount(boardVo.getLimit(),20));
        List<BoardVO> boardVOList = blogBoardMapper.getBoardList(boardVo);

        if(ObjectUtils.isEmpty(boardVOList)){
            throw new BoardListNotFoundException(ExceptionMessage.BOARD_LIST_NOT_EXIST_MESSAGE);
        }

        return boardVOList;
    }

    private void isActivateCategory(int boardCategoryKey){
        if(blogBoardMapper.checkBoardCategory(boardCategoryKey) < 1){
            throw new BoardCategoryNotExistException(ExceptionMessage.BOARD_CATEGORY_NOT_EXIST_MESSAGE);
        }
    }

    private int increaseLimitCount(int limit, int increase){
        return limit+increase;
    }

    @Override
    public BoardVO getBoardContent(int BoardKey) {
        BoardVO boardContentInfo = blogBoardMapper.getBoardContent(BoardKey);

        if(ObjectUtils.isEmpty(boardContentInfo)){
            throw new BoardNotFoundException(ExceptionMessage.BOARD_CONTENT_NOT_EXIST_MESSAGE);
        }

        isActivateCategory(boardContentInfo.getCategoryKey());

        return boardContentInfo;

    }

    @Override
    public void updateBoardContent(BoardVO boardVO) {
        if(isValidUpdateBoard(boardVO)){
            blogBoardMapper.updateBoardContent(boardVO);
        }else{
           throw new BoardVaildException(ExceptionMessage.BOARD_UPDATE_VAILD_FAIL_MESSAGE);
        }


    }

    private boolean isValidUpdateBoard(BoardVO boardVO){
        if(boardVO.getMemberKey() >0 && boardVO.getTitle() != ""  && boardVO.getContent() != ""){
            return true;
        }else{return false;}
    }

    @Override
    public void deleteBoardContent(BoardVO boardVO) {
        /*이부분은 로그인 처리 작업 하면서 공동 처리 (로그인 세션과 해당 요청 로그인 키 일치여부 판별하는부분)*/
        if(boardVO.getMemberKey() >0){
            blogBoardMapper.deleteBoardContent(boardVO.getBoardKey());
        }else{
            throw new BoardDeleteFailException(ExceptionMessage.BOARD_DELETE_FAIL_MESSAGE);
        }
    }


    @Override
    public List<BoardVO> getBoardCategory() {
        return blogBoardMapper.getBoardCategory();
    }

    @Override
    public List<BoardCommentVO> getBoardCommentList(int BoardKey) {
        return blogBoardMapper.getBoardCommentList(BoardKey);
    }

    @Override
    public void deleteBoardComment(int commentKey) {
        if(commentKey >=0){
            blogBoardMapper.deleteBoardComment(commentKey);
        }
    }

    @Override
    public void insertBoardComment(BoardCommentVO boardCommentVO) {
        if (isValidUpdateBoardComment(boardCommentVO)) {
            blogBoardMapper.insertBoardComment(boardCommentVO);
        }else{
            throw new BoardVaildException(ExceptionMessage.BOARD_INSERT_VAILD_FAIL_MESSAGE);
        }
    }

    private boolean isValidUpdateBoardComment(BoardCommentVO boardCommentVO){
        if(boardCommentVO.getMemberKey() >0 &&
            boardCommentVO.getBoardKey() >0  &&
            boardCommentVO.getCommentContent() != ""){
            return true;
        }else{return false;}
    }
}
