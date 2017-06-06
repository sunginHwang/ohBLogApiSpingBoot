package com.sungin.ohBlogApi.controller;

import com.sungin.ohBlogApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hwangseong-in on 2017. 6. 4..
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserService userService;


}
