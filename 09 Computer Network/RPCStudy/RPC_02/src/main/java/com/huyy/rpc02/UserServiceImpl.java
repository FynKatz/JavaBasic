package com.huyy.rpc02;


import com.huyy.rpc.common.User;
import com.huyy.rpc.common.UserService;

public class UserServiceImpl implements UserService {

    public User findUserById(Integer id) {
        return new User(id,"Alice");
    }
}
