package com.sungin.ohBlogApi.service.impl;

import com.sungin.ohBlogApi.service.BlogBoardService;
import com.sungin.ohBlogApi.dao.BlogBoardMapper;
import com.sungin.ohBlogApi.vo.BoardCommentVO;
import com.sungin.ohBlogApi.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        int checkCategoryActivate = blogBoardMapper.checkBoardCategory();

        if(isActivateCategory(checkCategoryActivate)){
            boardVo.setLimit(increaseLimitCount(boardVo.getLimit(),20));
            return blogBoardMapper.getBoardList(boardVo);
        }else{
            return null;
        }
    }

    private boolean isActivateCategory(int checkCategoryActivate){

        if(checkCategoryActivate >=1){
            return true;
        }else{
            return false;
        }
    }

    private int increaseLimitCount(int limit, int increase){
        return limit+increase;
    }

    @Override
    public BoardVO getBoardContent(int BoardKey) {
        BoardVO boardContentInfo = blogBoardMapper.getBoardContent(BoardKey);
        if(isActivateCategory(boardContentInfo.getCategoryKey())){
            return boardContentInfo;
        }else{
            return null;
        }

    }

    @Override
    public void updateBoardContent(BoardVO boardVO) {
        if(isValidUpdateBoard(boardVO)){
            blogBoardMapper.updateBoardContent(boardVO);
        }else{
            System.out.println("로그인 or 양식 잘못 처리");
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
            System.out.println("안될때의 처리");
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
            System.out.println("유효성 처리 못할경우");
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
