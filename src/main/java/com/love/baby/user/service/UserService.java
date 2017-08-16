package com.love.baby.user.service;

import com.love.baby.user.dao.UserDao;
import com.love.baby.user.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liangbc on 2017/8/8.
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public Users getById(String id) {
        return userDao.findById(id);
    }
}
