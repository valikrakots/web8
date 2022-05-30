<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Get actors</title>
</head>
<body>
    <div class="page">
        <h3>Enter film name.</h3>

        <form class="form" method="POST">
            Film name: <input type = "text" size="40" name = "film_name" placeholder="Film's name">
            <button type="submit" onclick="window.open('${pageContext.request.contextPath}?command=getActorsOfFilmResult')">Submit</button>
        </form>

    </div>
</body>
</html>
