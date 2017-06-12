package com.sungin.ohBlogApi.config.security.filter;

import com.sungin.ohBlogApi.config.security.AuthToken;
import com.sungin.ohBlogApi.service.UserService;
import com.sungin.ohBlogApi.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import javax.annotation.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by hwangseong-in on 2017. 6. 6..
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthFilter extends GenericFilterBean {
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private UserService userService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = this.getAsHttpRequest(request);
        String authToken = this.extractAuthTokenFromRequest(httpRequest);
        String username = AuthToken.getUserName(authToken);

        logger.debug("==============> AuthTokenFilter");
        logger.debug("authToken: " + authToken);
        logger.debug("username: " + username);

        if (username != null) {
            UserDetails userDetails = userService.loadUserByUsername(username);
            UserVO userVO = new UserVO(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
            if (!AuthToken.validate(authToken, userVO)) {
                SecurityContextHolder.clearContext();
            } else {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userVO, userVO.getPassword(), userVO.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }


    private HttpServletRequest getAsHttpRequest(ServletRequest request) {
        if (!(request instanceof HttpServletRequest)) {
            throw new RuntimeException("Expecting an HTTP request");
        }

        return (HttpServletRequest) request;
    }


    private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
        String authToken = httpRequest.getHeader("X-Auth-Token");
        return authToken;
    }
}
