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
            <h3></h3>
            <form class="form" method="POST">
                Login: <input type = "text" size = "40" name = "login"  />
                Password: <input type = "text" size = "40" name = "password" />
                Confirm Password: <input type = "text" size = "40" name = "confirm_password"/>
                <input type = "submit" value = Login />
            </form>
            <p>${error}</p>
        </div>
    </body>
</html>