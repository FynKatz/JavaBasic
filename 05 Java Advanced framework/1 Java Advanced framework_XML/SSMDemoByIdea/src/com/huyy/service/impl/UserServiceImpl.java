package com.huyy.service.impl;

import com.huyy.dao.UserDao;
import com.huyy.pojo.User;
import com.huyy.service.UserSercice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserSercice{

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public List<User> getUser() {
        return userDao.selectAllUser();
    }
}
