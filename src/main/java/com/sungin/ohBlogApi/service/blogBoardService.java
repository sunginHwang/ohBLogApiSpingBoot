package com.sungin.ohBlogApi.service;

import com.sungin.ohBlogApi.vo.BoardVO;
import com.sungin.ohBlogApi.vo.BoardCommentVO;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 6. 3..
 */
public interface BlogBoardService {
    public List<BoardVO> getBoardList(BoardVO boardVo);
    public BoardVO getBoardContent(int BoardKey);
    public void updateBoardContent(BoardVO boardVO);
    public void deleteBoardContent(BoardVO boardVO);
    public List<BoardVO> getBoardCategory();
    public List<BoardCommentVO> getBoardCommentList(int BoardKey);
    public void deleteBoardComment(int commentKey);
    public void insertBoardComment(BoardCommentVO boardCommentVO);
}
