<%@ page import="Models.Auth" %>
<%@ page language="java" contentType="text/html;charset=UTF-16BE"
         pageEncoding="UTF-16BE"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<c:set var="language" value="en" />

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale" />


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="app.title"/></title>

</head>
<body>
<%Auth user = (Auth) session.getAttribute("user"); %>
<%String userType = (user == null ? "null" : user.getUser_type()); %>

<div class="main-page">
    <div class="menu">

        <h1>Menu</h1>
        <%if (userType.equals("M")) {%>
            <button type="button"><a style="text-decoration: none" href="${pageContext.request.contextPath}?command=showMenu">Show menu</a></button>
            <button type="button"><a href="${pageContext.request.contextPath}?command=chat">Chat</a></button>
        <%}%>
        <%if (userType.equals("C")) {%>
            <button type="button"><a style="text-decoration: none" href="${pageContext.request.contextPath}?command=showMenu">Show Menu</a></button>
            <button type="button"><a href="${pageContext.request.contextPath}?command=chat">Chat></a></button>
        <%}%>
    </div>
</div>

<div >
    <%if (userType.equals("null")) {%>
        <button type="button"><a href="${pageContext.request.contextPath}?command=authorization">Login </a></button>
        <button type="button"><a href="${pageContext.request.contextPath}?command=registration">Registration</a></button>
    <%} else {%>
        <button type="button"><a href="${pageContext.request.contextPath}?command=logOut">LogOut</a></button>
    <%}%>
</div>
</body>
</html>


