package com.huyy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huyy.pojo.User;
import com.huyy.service.UserDao;

import net.sf.json.JSONObject;


@Controller
public class UserController {
	
	@Resource
	private UserDao userdao;

	@RequestMapping("/showUser")
//	@ResponseBody
	public String showUser(Model model) {
		
		List<User> list = new ArrayList<>();
		list = userdao.findALL();

		model.addAttribute("list", list);

		return "userList";
	}
	
	@RequestMapping("/showUser2")
	@ResponseBody
	public List<User> showUser2() {
		
		List<User> list = new ArrayList<>();
		list = userdao.findALL();
		return list;
	}
	
	//简单Get + 无参
	@RequestMapping(value="/showUser3",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	public ResponseEntity<String> showUser3(){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Access-Control-Allow-Origin", "*");//设置可跨域
		Map<String, Object> result = new HashMap<>();
		JSONObject jsonObject;
		
		try {
			List<User> list = userdao.findALL();//调用Dao
			result.put("data", list);
			jsonObject = JSONObject.fromObject(result);
			return new ResponseEntity<>(jsonObject.toString(),headers,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("errorInfo", e.getMessage());
			jsonObject = JSONObject.fromObject(result);
			return new ResponseEntity<>(jsonObject.toString(),headers,HttpStatus.OK);
		}
	}

	//Get + 传入一个字符串
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
    public ResponseEntity<String> getUserById(int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "*");// 设置可跨域
        Map<String, Object> result = new HashMap<>();
        JSONObject jsonObject;   

        try {
            List<User> list = userdao.getUserById(id);// 调用Dao
            result.put("data", list);
            jsonObject = JSONObject.fromObject(result);
            return new ResponseEntity<>(jsonObject.toString(), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("errorInfo", e.getMessage());
            jsonObject = JSONObject.fromObject(result);
            return new ResponseEntity<>(jsonObject.toString(), headers, HttpStatus.OK);
        }
    }
    
    //Get + 传入多个字符串
    @RequestMapping(value = "/getUserByIdName", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
    public ResponseEntity<String> getUserByIdName(int id,String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "*");// 设置可跨域
        Map<String, Object> result = new HashMap<>();
        JSONObject jsonObject;   

        try {
            List<User> list = userdao.getUserByIdName(id,name);// 调用Dao
            result.put("data", list);
            jsonObject = JSONObject.fromObject(result);
            return new ResponseEntity<>(jsonObject.toString(), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("errorInfo", e.getMessage());
            jsonObject = JSONObject.fromObject(result);
            return new ResponseEntity<>(jsonObject.toString(), headers, HttpStatus.OK);
        }
    }
    
    
    //post + 传入多个字符串
    @RequestMapping(value = "/getUserByIdName2", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    public ResponseEntity<String> getUserByIdName2(int id,String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "*");// 设置可跨域
        Map<String, Object> result = new HashMap<>();
        JSONObject jsonObject;   

        try {
            List<User> list = userdao.getUserByIdName(id,name);// 调用Dao
            result.put("data", list);
            jsonObject = JSONObject.fromObject(result);
            return new ResponseEntity<>(jsonObject.toString(), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("errorInfo", e.getMessage());
            jsonObject = JSONObject.fromObject(result);
            return new ResponseEntity<>(jsonObject.toString(), headers, HttpStatus.OK);
        }
    }
    
    
    
    
    
    
    
	
  
    
	//传入json（而不是User对象，方便调取）
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    public ResponseEntity<String> saveUser(@RequestParam(value="param",required=false)String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "*");// 设置可跨域
        headers.set("Access-Control-Allow-Headers", "content-type, accept");
        headers.set("Access-Control-Allow-Methods", "POST");
        Map<String, Object> result = new HashMap<>();
        JSONObject jsonObject;
        
        JSONObject jo = JSONObject.fromObject(param);//传入参数

        try {
            String Feedback = userdao.saveUser(jo);// 调用Dao
            result.put("success", Feedback);
            jsonObject = JSONObject.fromObject(result);
            return new ResponseEntity<>(jsonObject.toString(), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("errorInfo", e.getMessage());
            jsonObject = JSONObject.fromObject(result);
            return new ResponseEntity<>(jsonObject.toString(), headers, HttpStatus.OK);
        }
    }
	
}












