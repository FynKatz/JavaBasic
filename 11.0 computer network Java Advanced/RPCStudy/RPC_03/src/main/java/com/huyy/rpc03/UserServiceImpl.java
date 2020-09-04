package com.huyy.rpc03;


import com.huyy.rpc.common.User;
import com.huyy.rpc.common.UserService;

public class UserServiceImpl implements UserService {
    public User findUserById(Integer id) {
        return new User(123,"Alice");
    }
}
