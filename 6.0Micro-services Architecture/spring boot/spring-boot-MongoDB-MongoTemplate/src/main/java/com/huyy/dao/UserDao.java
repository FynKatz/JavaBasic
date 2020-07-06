package com.huyy.dao;

import com.huyy.pojo.User;

public interface UserDao {

    public void saveUser(User user);

    public User findUserByUserName(String userName);

    public String updateUser(User user);

    public void deleteUserById(Long id);

}
