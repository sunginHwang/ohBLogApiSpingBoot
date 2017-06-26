package com.sungin.ohBlogApi.controller;

import com.sungin.ohBlogApi.service.BlogBoardService;
import com.sungin.ohBlogApi.vo.BoardCommentVO;
import com.sungin.ohBlogApi.vo.BoardContentVO;
import com.sungin.ohBlogApi.vo.BoardVO;
import com.sungin.ohBlogApi.exception.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 6. 3..
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BlogBoardService blogBoardService;


    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public List<BoardVO> getBoardList(@RequestParam(value = "limit" ,required = true,defaultValue = "0")int limit,
                                      @RequestParam(value = "category" ,required = true,defaultValue = "-1")int categoryKey) throws Exception {

        BoardVO boardVO = new BoardVO(categoryKey,limit,"N");
        List<BoardVO> getBoardList = blogBoardService.getBoardList(boardVO);

        if(ObjectUtils.isEmpty(getBoardList)){
            throw new BoardListNotFoundException("존재하는 게시글이 없습니다.");
        }

        return getBoardList;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<BoardVO> getBoardCategory(){
        return blogBoardService.getBoardCategory();
    }

    @RequestMapping(value = "/content/{boardKey}" , method = RequestMethod.GET)
    public BoardContentVO getBoardContent(@PathVariable int boardKey){
        BoardVO boardContent = blogBoardService.getBoardContent(boardKey);

        List<BoardCommentVO> boardCommentVOList = blogBoardService.getBoardCommentList(boardKey);
        BoardContentVO boardContentVO = new BoardContentVO(boardContent,boardCommentVOList);
        return boardContentVO;
    }

    @RequestMapping(value = "/content/{boardKey}", method = RequestMethod.PUT)
    public void updateBoardContnet(@ModelAttribute BoardVO boardVO){
        blogBoardService.updateBoardContent(boardVO);
    }

    @RequestMapping(value = "/content/{boardKey}", method = RequestMethod.DELETE)
    public void deleteBoardContnet(@ModelAttribute BoardVO boardVO){
        blogBoardService.deleteBoardContent(boardVO);
    }

    @RequestMapping(value= "/comment/{commentKey}", method = RequestMethod.POST)
    public void insertBoardComment(@ModelAttribute BoardCommentVO boardCommentVO){
        blogBoardService.insertBoardComment(boardCommentVO);
    }

    @RequestMapping(value= "/comment/{commentKey}", method = RequestMethod.DELETE)
    public void deleteBoardComment(@PathVariable int commentKey){
        blogBoardService.deleteBoardComment(commentKey);
    }








}
