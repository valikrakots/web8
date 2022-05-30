<%@ page import="Models.Auth" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>

<!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
            <title>Videoteka</title>
            <script type="text/javascript">
                var websocket;
                var lang;

                function init() {
                    websocket = new WebSocket('ws://localhost:8080/lab5_1_war/chat');
                    websocket.onopen = function (event) {
                        websocketOpen(event);
                    };
                    websocket.onmessage = function (event) {
                        websocketMessage(event);
                    };
                    websocket.onerror = function (event) {
                        websocketError(event);
                    };
                }

                function websocketOpen(event) {
                    console.log("webSocketOpen invoked");
                    websocket.send("[web_socket_message]:=:" + document.getElementById('senderId').value);
                }

                function websocketMessage(event) {
                    console.log("websocketMessage invoked");
                    document.getElementById('chatWindow').value += '\n' + event.data;
                }

                function websocketError(event) {
                    console.log("websocketError invoked");
                }

                function sendMessage() {
                    var msg = document.getElementById('chatInput');
                    if (msg.value === "") return;
                    websocket.send(msg.value);

                    document.getElementById('chatWindow').value += '\n' + 'I: ' + msg.value;


                    msg.value = "";
                }

                function closeConnection() {
                    websocket.close();
                }

                window.addEventListener("load", init);
                window.addEventListener("unload", closeConnection);
            </script>
        <body>

            <%Auth user = (Auth) session.getAttribute("user"); %>
            <%String userType = (user == null ? "null" : user.getUser_type()); %>

            <input type="hidden" id="senderId" value="${senderId}">
            <div>
                <%if (userType.equals("M")) {%>
                    <p>Manager</p>
                <%}%>
                <textArea id="chatWindow" rows="10" style="width: 44em;margin: 15px" readonly></textArea>
            </div>
            <div>
                <input type="text" id="chatInput" style="width: 40em;margin: 15px"/>
                <input id="sendBtn" type="button" class="btn btn-primary" value="Send" onclick="sendMessage()"/>
            </div>
        </body>
    </html>
