package com.huyy.controller;

import com.huyy.pojo.User;
import com.huyy.service.UserSercice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 13926 on 2017/7/18.
 */
@Controller
@RequestMapping(value = "")           //表示任何路径都可映射进来
public class UserController {
    @Resource(name = "userService")
    UserSercice userService;

    @RequestMapping(value = "show")   //表示路径---》项目名/show
    public ModelAndView list()
    {
        ModelAndView mv=new ModelAndView();
        List<User>  userList=userService.getUser();
        mv.addObject("userList",userList);
        mv.setViewName("show");
        return mv;
    }

}

