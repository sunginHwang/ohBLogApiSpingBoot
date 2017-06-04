package com.sungin.ohBlogApi.dao;

import com.sungin.ohBlogApi.vo.BoardVO;
import com.sungin.ohBlogApi.vo.BoardCommentVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 6. 3..
 */
@Repository(value = "blogBoardMapper")
public interface BlogBoardMapper {
    public int checkBoardCategory();
    public List<BoardVO> getBoardList(BoardVO boardVO);
    public void updateBoardContent(BoardVO boardVO);
    public void deleteBoardContent(int boardKey);
    public BoardVO getBoardContent(int boardKey);
    public List<BoardVO> getBoardCategory();
    public List<BoardCommentVO> getBoardCommentList(int boardKey);
    public void deleteBoardComment(int commentKey);
    public void insertBoardComment(BoardCommentVO boardCommentVO);

}
