package com.love.baby.user.controller;

import com.love.baby.user.entity.Users;
import com.love.baby.user.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liangbc on 2017/8/8.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users getByid(@PathVariable String id) {
        return userService.getById(id);
    }
}
