package com.sungin.ohBlogApi.config.security.handler;

import com.sungin.ohBlogApi.config.security.AuthToken;
import com.sungin.ohBlogApi.service.UserService;
import com.sungin.ohBlogApi.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hwangseong-in on 2017. 6. 4..
 */
@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(AuthSuccessHandler.class);

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.debug("==============> LOGIN_SUCCESS");
        logger.debug("username: " + authentication.getName());
        logger.debug("password: " + authentication.getPrincipal());
        UserDetails userDetails = userService.loadUserByUsername(authentication.getName());

        String accessToken = AuthToken.create(new UserVO(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities()));

        logger.debug("===============> Access Token Create: " + accessToken);

        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();
        writer.write(accessToken);
        writer.flush();
    }
}
