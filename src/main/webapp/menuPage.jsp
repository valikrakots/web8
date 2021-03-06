<%@ page import="Models.Auth" %>
<!DOCTYPE html>
<html>
    <body>
    <%Auth user = (Auth) session.getAttribute("user"); %>
    <%String userType = (user == null ? "null" : user.getUser_type()); %>
        <header>
                <p>Меню библиотеки
                    <br>1) Вывести информацию о всех фильмах.
                    <br>2) Вывести информацию о всех хороших фильмах.
                    <br>3) Вывести информацию о всез актерах фильма.
                    <%if (userType.equals("M")) {%>
                        <br>4) Вывести id фильмов
                    <%}%>
                </p>
        </header>
        <div class="main-page">
            <div class="menu">
                <h1>MENU</h1>
                <button type="button" onclick="window.open('${pageContext.request.contextPath}?command=showAllFilmsCommand')" >Все фильмы</button>
                <button type="button" onclick="window.open('${pageContext.request.contextPath}?command=showGoodFilmsCommand')" >Хорошие фильмы</button>
                <button type="button" onclick="window.open('${pageContext.request.contextPath}?command=getActorsOfFilm')">Актеры фильма</button>
                <%if (userType.equals("M")) {%>
                    <button type="button" onclick="window.open('${pageContext.request.contextPath}?command=getFilmsId')">ID фильмов</button>
                <%}%>
            </div>
        </div>
    </body>
</html>