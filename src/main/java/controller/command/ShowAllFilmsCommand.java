package controller.command;

import DAO.FilmsDAO;
import Models.Film;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowAllFilmsCommand extends Command {

    final String urlPattern = "showAllFilmsCommand";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        String errorString = null;

        ArrayList<Film> list = null;
        try {
            FilmsDAO B = new FilmsDAO();
            list = (ArrayList<Film>) B.getAllFilms();
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("filmsList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/showAllFilmsPage.jsp");
        dispatcher.forward(request, response);
    }
}
