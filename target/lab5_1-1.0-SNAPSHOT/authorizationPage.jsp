<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Videoteka</title>
    </head>
    <body>
        <div class="page">
            <h3>LOG IN</h3>
            <form class="form" method="POST">
                Login: <input type = "text" size = "40" name = "login" placeholder = "Login"/>
                Password: <input type = "text" size = "40" name = "password" placeholder = "Password"/>
                <input type = "submit" value = "Login" />
                <input type = "hidden" name = "command" value = "authorization">
                <p>${error}</p>
            </form>
        </div>
    </body>
</html>