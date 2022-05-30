<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Good films</title>
    </head>
    <body>
        <c:if test="${!empty filmsList}">
            <div class="page-table">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Raiting</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${filmsList}" var="film">
                        <tr>
                            <td>${film.title}</td>
                            <td>${film.raiting}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>