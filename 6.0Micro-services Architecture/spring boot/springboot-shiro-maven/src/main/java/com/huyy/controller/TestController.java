package com.huyy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**  
* @Description: 测试
* @author yyhu
* @date 2020年6月7日  
* @version V1.0  
*/
@Controller
public class TestController {
	
	@RequestMapping("hello")
	@ResponseBody
	public String test() {
		return "success";//@ResponseBody
	}
	
	@RequestMapping("add")
	public String add(){
		return "/user/add";//跳转html
	}
	
	@RequestMapping("update")
	public String update(){
		return "/user/update";//跳转html
	}
	
	@RequestMapping("login")
	public String login(){
		return "/login";//跳转html
	}
	
	@RequestMapping("testThymeLeaf")
	public String testThymeLeaf(Model model) {
		//数据存入model
		model.addAttribute("name", "测试");
		//返回test.html
		return "test";
	}
	
	@RequestMapping("noAuth")
	public String noAuth(){
		return "noAuth";
	}
	
	/**
	 * 登录逻辑处理
	 */
	@RequestMapping("/signin")
	public String login(String name,String password,Model model){
		
		/**
		 * 使用Shiro编写认证操作
		 */
		//1.获取Subject
		Subject subject = SecurityUtils.getSubject();
		
		//2.封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		
		//3.执行登录方法
		try {
			subject.login(token);//登录成功	
//			return "redirect:testThymeleaf";//重定向到testThymeleaf请求（controller）
			return "test";//跳转到test页面,两种方式都可以。
		} catch (UnknownAccountException e) {
			//登录失败:用户名不存在
			model.addAttribute("msg", "用户名不存在");
			return "login";//跳转login页面
//			return "redirect:login";//重定向。但是因为重定向后，参数就传不出，这里用上面的跳转方式。
		}catch (IncorrectCredentialsException e) {
			//登录失败:密码错误
			model.addAttribute("msg", "密码错误");
			return "login";//跳转login页面
//			return "redirect:login";//重定向。但是因为重定向后，参数就传不出，这里用上面的跳转方式。
		}
	}
}
 
