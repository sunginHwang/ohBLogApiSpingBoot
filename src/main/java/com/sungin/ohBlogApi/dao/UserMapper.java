package com.sungin.ohBlogApi.dao;

import com.sungin.ohBlogApi.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 6. 6..
 */
@Repository(value = "userMapper")
public interface UserMapper {
    public UserVO getUserInfo(String username);
    public List<String> readAuthority(String username);
    public String test();
}
