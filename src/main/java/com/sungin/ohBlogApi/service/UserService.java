package com.sungin.ohBlogApi.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

/**
 * Created by hwangseong-in on 2017. 6. 6..
 */
public interface UserService extends UserDetailsService {
    Collection<GrantedAuthority> getAuthority(String memberId);
    public String testCookie();
}
