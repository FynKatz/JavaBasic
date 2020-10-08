<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">

	var ws = null;//一个websocket代表一个通信管道
	
	//打开websocket
	function subOpen() {
		var target = "ws://localhost:8080/websocket01/echo";
		if ('WebSocket' in window) {
			ws = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			ws = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}
		
		//从服务器接收
		ws.onmessage=function(event){
			var dv=document.getElementById("dv");
			dv.innerHTML+=event.data;
		};
	}
	
	//发送到服务器
	function subSend(){
		var msg=document.getElementById("msg").value;//下面<input>里的id是msg
		ws.send(msg);
		document.getElementById("msg").value="";
	}
	
	
</script>

</head>
<body>

<button onclick="subOpen();">打开websocket</button>

<input id="msg"/>
<button onclick="subSend();">发送到服务器</button>

<div id="dv"></div>
</body>
</html>