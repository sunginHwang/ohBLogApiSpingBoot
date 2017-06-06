package com.sungin.ohBlogApi.service.impl;

import com.sungin.ohBlogApi.dao.UserMapper;
import com.sungin.ohBlogApi.service.UserService;
import com.sungin.ohBlogApi.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hwangseong-in on 2017. 6. 6..
 */
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVO = userMapper.getUserInfo(username);
        userVO.setAuthorities(getAuthority(username));
        return userVO;
    }

    @Override
    public Collection<GrantedAuthority> getAuthority(String memberId) {
        List<String> stringAuthorities = userMapper.readAuthority(memberId);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : stringAuthorities) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;

    }



}
