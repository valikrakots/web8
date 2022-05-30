package controller.command;


import DAO.AuthorizationDAO;
import Models.Auth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationCommand extends Command {

    final String urlPattern = "registration";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/registrationPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        if(request.getParameter("command").equals("registration")){
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            String errorString = "";

            try{
                AuthorizationDAO daoUser = new AuthorizationDAO();
                if(daoUser.loginHandler(login)){
                    errorString = "User with this login already exists.";
                    HttpSession session = request.getSession(true);
                    session.setAttribute("error", errorString);
                    request.getRequestDispatcher("/registrationPage.jsp").forward(request, response);
                }
                else {
                    Auth user = new Auth(login, password, "C");
                    daoUser.createAccount(user);

                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", user);
                    session.setAttribute("error", errorString);

                    request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

