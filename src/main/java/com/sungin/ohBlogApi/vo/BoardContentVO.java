package com.sungin.ohBlogApi.vo;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 6. 4..
 */
public class BoardContentVO {
    private BoardVO boardVO;
    private List<BoardCommentVO> boardCommentVOList;

    public BoardVO getBoardVO() {
        return boardVO;
    }

    public void setBoardVO(BoardVO boardVO) {
        this.boardVO = boardVO;
    }

    public List<BoardCommentVO> getBoardCommentVOList() {
        return boardCommentVOList;
    }

    public void setBoardCommentVOList(List<BoardCommentVO> boardCommentVOList) {
        this.boardCommentVOList = boardCommentVOList;
    }

    public BoardContentVO(BoardVO boardVO, List<BoardCommentVO> boardCommentVOList) {
        this.boardVO = boardVO;
        this.boardCommentVOList = boardCommentVOList;
    }

    public BoardContentVO(){

    }
}
