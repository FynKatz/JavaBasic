package com.huyy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;//注意
import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisSessionController {

	@GetMapping("/setSession")
    public Map<String,Object> setUrl(HttpServletRequest request){
        request.getSession().setAttribute("url", request.getRequestURL());
        Map<String,Object> map = new HashMap<>();
        map.put("url", request.getRequestURL());
        return map;
    }

    @GetMapping("/getSession")
    public Map<String,Object> getSession(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("url", request.getSession().getAttribute("url"));
        return map;
    }
}