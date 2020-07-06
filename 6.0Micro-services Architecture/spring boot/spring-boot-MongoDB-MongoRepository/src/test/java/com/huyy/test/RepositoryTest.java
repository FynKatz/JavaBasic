package com.huyy.test;

import com.huyy.dao.UserDao;
import com.huyy.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() throws Exception {
        for (long i=0;i<10;i++) {
            User user=new User();
            user.setId(i);
            user.setUserName("员工"+i);
            user.setPassWord("password"+i);
            userDao.save(user);
        }
    }

    @Test
    public void findUserByUserName(){
      User user= userDao.findByUserName("员工1");
       System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(2l);
        user.setUserName("小王");
        user.setPassWord("ddaxmh");
        userDao.save(user);
    }

    @Test
    public void deleteUserById(){
        userDao.delete(3l);
    }

    @Test
    public void testPage(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(2, 3, sort);
        Page page=userDao.findAll(pageable);
        System.out.println("users: "+page.getContent().toString());
    }

}
