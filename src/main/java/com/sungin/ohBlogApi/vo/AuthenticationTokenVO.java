package com.sungin.ohBlogApi.vo;

import java.util.Collection;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by hwangseong-in on 2017. 6. 4..
 */
public class AuthenticationTokenVO {
    private String username;
    private Object authorities;
    private String token;

    public AuthenticationTokenVO(String username,Object authorities, String token) {
        this.username = username;
        this.authorities = authorities;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Object getAuthorities() {
        return authorities;
    }
    public void setAuthorities(Object authorities) {
        this.authorities = authorities;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
