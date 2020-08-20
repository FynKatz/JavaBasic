package com.wiscom.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wiscom.bean.TestBean;
import com.wiscom.config.InitConfig;
import com.wiscom.service.TestService;
import com.wiscom.util.JsonDateValueProcessor;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
* @author gavin
* @version 创建日期:2019年5月28日
*/

@Controller
public class WebSocketController {

	@Autowired
	InitConfig initConfig;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private TestService testService;
	
	private String code;
	
	/*
	 * http request
	 * */
	@RequestMapping(value="/httpTest",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ResponseEntity<String> httpTest(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<TestBean> list = testService.httpTest();
		result.put("data", list);
		result.put("status", "success");
		
		return constructResponseEntity(result);
		
	}

	public ResponseEntity<String> constructResponseEntity(Map<String, Object> result){
		
        HttpHeaders headers = new HttpHeaders();
        
        headers.set("Access-Control-Allow-Origin", "*");
        
        JsonConfig cfg = new JsonConfig();
		
        cfg.registerJsonValueProcessor(java.sql.Timestamp.class, new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));
        
        JSONObject jsonObj = JSONObject.fromObject(result,cfg);
		
        return new ResponseEntity<String>(jsonObj.toString(),headers,HttpStatus.OK);
		
	}
  	
  	@MessageMapping("/test/{code}")
  	public String recieveCommand(@DestinationVariable("code")String code,StompHeaderAccessor accessor) throws Exception
  	{
  		String ip = (String) accessor.getSessionAttributes().get("ip");
  		return "success";
  	}
	
	/*
	 * websocket subscribe
	 * */
  	@SubscribeMapping("/sendCommand")
	public void sendCommand(StompHeaderAccessor accessor) throws Exception 
  	{
  		String ip = (String) accessor.getSessionAttributes().get("ip");
  		
		Map m=new HashMap();
		
		m.put("code", code);
		
		template.convertAndSend("/topic/sendCommand", m);
  	}

}
