package controller.command;


import DAO.FilmsDAO;
import Models.Film;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetFilmsIdCommand extends command.Command {

    final String urlPattern = "getFilmsId";

    public List<Film> filmList;

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        String errorString = null;
        try {
            filmList = (new FilmsDAO()).getAllFilms();
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("filmList", filmList);;

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/getFilmsIdPage.jsp");
        dispatcher.forward(request, response);
    }
}

