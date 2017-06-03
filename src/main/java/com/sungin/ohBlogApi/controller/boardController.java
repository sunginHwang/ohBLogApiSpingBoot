package com.sungin.ohBlogApi.controller;

import com.sungin.ohBlogApi.dao.blogBoardMapper;
import com.sungin.ohBlogApi.vo.BibleContentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 6. 3..
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/board")
public class boardController {

    @Autowired
    private blogBoardMapper blogBoardMapper;


    @RequestMapping("/test")
    public List<BibleContentModel> test() throws Exception{
        return blogBoardMapper.selectBibleContents();
    }

}
