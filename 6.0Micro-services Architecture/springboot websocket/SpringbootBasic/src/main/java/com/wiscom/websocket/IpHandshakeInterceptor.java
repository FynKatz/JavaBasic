package com.wiscom.websocket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
* @author gavin
* @version 创建日期:2019年5月29日
*/

public class IpHandshakeInterceptor implements HandshakeInterceptor { 

    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, 
      WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception { 

     // Set ip attribute to WebSocket session 
     String ip = request.getRemoteAddress().toString();
     ip = ip.substring(ip.indexOf("/")+1, ip.indexOf(":"));
     attributes.put("ip", ip); 

     return true; 
    } 

    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, 
      WebSocketHandler wsHandler, Exception exception) {   
    } 
} 
