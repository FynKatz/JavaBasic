package com.huyy.rpc01;


import com.huyy.rpc.common.User;
import com.huyy.rpc.common.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findUserById(Integer id) {

        return new User(id, "Alice");
    }
}
