var stompClient = null;

/* 1.连接websocket */
function connect() {
	// 1.1建立连接对象，与后台代码registerStompEndpoints()中注册的endpoint一致
	var socket = new SockJS('/endpoint-websocket');
	// 1.2创建STOMP协议的webSocket客户端
	stompClient = Stomp.over(socket);
	// 1.3连接webSocket的服务端
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		// 客户端订阅服务器地址"/topic/game_chat"发送的消息，与@SendTo中的地址对应。
		stompClient.subscribe('/topic/game_chat', function(result) {
			showContent(JSON.parse(result.body));
		});
	});
}

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#notice").html("");
}

// 展示系统的通知消息
function showContent(body) {
	$("#notice").append(
			"<tr><td>" + body.content + "</td> <td>"
					+ new Date(body.time).toLocaleString() + "</td></tr>");
}

/* ------------------------------------------------------------------------------------- */
/* 2.断开连接websocket */
function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

/* ------------------------------------------------------------------------------------- */
/* 3.发送消息 */
function sendName() {
	// 客户端向地址"/app/chat"的服务器地址发送消息，与@MessageMapping里的地址对应。
	stompClient.send("/app/chat", {}, JSON.stringify({
		'content' : $("#content").val()
	}));
}

/* ------------------------------------------------------------------------------------- */
/* 当文档加载完成,就执行 */
$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();// 阻止提交到表单form，但是通过#send发送处罚
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendName();
	});// 发送消息
});
