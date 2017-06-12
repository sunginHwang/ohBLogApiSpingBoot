package com.sungin.ohBlogApi.controller;

import com.sungin.ohBlogApi.service.UserService;
import com.sungin.ohBlogApi.vo.AuthenticationTokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;
import com.sungin.ohBlogApi.vo.UserVO;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hwangseong-in on 2017. 6. 4..
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public AuthenticationTokenVO userLogin(@ModelAttribute UserVO userVO,
                                           HttpSession session){
        String username = userVO.getUsername();
        String password = userVO.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                             SecurityContextHolder.getContext());

        UserDetails userDetails = userService.loadUserByUsername(userVO.getUsername());
        System.out.println("DETAIL : "+userDetails.getPassword() + " " + userDetails.getAuthorities() + "  " + userDetails.getUsername());
        final Map<String, Boolean> roles = new HashMap<String, Boolean>();

        for (GrantedAuthority authority : userService.getAuthority(userVO.getUsername())) {
            roles.put(authority.toString(), Boolean.TRUE);
        }
        AuthenticationTokenVO authenticationTokenVO = new AuthenticationTokenVO(userVO.getUsername(),roles,session.getId());
        System.out.println(authenticationTokenVO);
        return authenticationTokenVO;

    }


}
