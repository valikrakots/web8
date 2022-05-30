<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>



<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="app.title"/></title>
    <%@taglib uri="/tag.tld"
              prefix="mytags" %>
</head>
<body>
<div class="page">
    <mytags:MyTag/>
</div>
</body>
</html>
