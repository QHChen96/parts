<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/9
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input id="message" type="text"/>
<input id="send" type="button" value="发送"/>
<script src="//cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script>
<script>
    var websocket;
    var message = document.getElementById("message");
    message.value = "赋值";
    var send = document.getElementById("send");
    if('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8888/webSocketServer");
    } else if('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://localhost:8888/webSocketServer");
    } else {
        websocket = new SockJS("ws://localhost:8888/sockjs/webSocketServer");
    }
    websocket.onopen(function (event) {
        console.log("open...");
    });
    websocket.onmessage(function (event) {
        message.value = event.data;
    });
    websocket.onerror = function (event) {
        console.log("error...");
    };
    websocket.onclose = function (event) {
        console.log("close...");
    }
    send.onclick(function () {
        websocket.send("Hello webSocket");
    });
</script>
</body>
</html>
