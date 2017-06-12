package com.sungin.ohBlogApi.config.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hwangseong-in on 2017. 6. 4..
 */
@Component
public class HttpLogoutSuccessHandler implements LogoutSuccessHandler {


    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if(authentication == null){
            httpServletResponse.setStatus(httpServletResponse.SC_BAD_REQUEST);
        }else{
            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            PrintWriter pw = httpServletResponse.getWriter();
            pw.write(authentication.getName()+" is"+" logout success");
            pw.flush();
        }
    }
}
