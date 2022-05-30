package controller.command;

import Connector.Exceptions.JDBCConnectionException;
import DAO.ActorsDAO;
import DAO.Exceptions.DAOException;
import Models.Actor;
import controller.MainServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetFilmActorsResultCommand extends command.Command {

    final String urlPattern = "getActorsOfFilmResult";

    public static String name = "";
    public static ArrayList<Actor> list;


    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException, JDBCConnectionException, DAOException {
        list = (ArrayList<Actor>) (new ActorsDAO()).getActorsOfFilm(name);
        request.setAttribute("actorsList", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/getActorsOfFilmResultPage.jsp");
        dispatcher.forward(request, response);
    }
}
