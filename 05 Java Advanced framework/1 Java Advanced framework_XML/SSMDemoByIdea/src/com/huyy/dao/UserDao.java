package com.huyy.dao;

import org.springframework.stereotype.Repository;

import com.huyy.pojo.User;

import java.util.List;

@Repository("userDao")  //@Repository 会被作为持久层操作（数据库）的bean来使用 ，功能同@Component
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUser();
}
