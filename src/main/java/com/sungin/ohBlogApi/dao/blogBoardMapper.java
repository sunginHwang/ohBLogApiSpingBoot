package com.sungin.ohBlogApi.dao;

import com.sungin.ohBlogApi.vo.BibleContentModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 6. 3..
 */
@Repository(value = "blogBoardMapper")
public interface blogBoardMapper {
    public List<BibleContentModel> selectBibleContents() throws Exception;
}
