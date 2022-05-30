<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Actors of film</title>
</head>
<body>
<div class="page">
    <h3>All actors of film</h3>

    <table border="1" cellpadding="5" cellspacing="1" style="border-collapse: collapse">
        <tr>
            <th>Fio</th>
        </tr>
        <c:forEach items="${actorsList}" var="actor" >
            <tr>
                <td>${actor.fio}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>