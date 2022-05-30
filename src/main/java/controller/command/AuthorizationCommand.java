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

public class AuthorizationCommand extends Command {

    final String urlPattern = "authorization";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/authorizationPage.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        if(request.getParameter("command") == null ||
                request.getParameter("command").equals("authorization")){
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            String errorString = "";

            try{
                AuthorizationDAO daoUser = new AuthorizationDAO();
                if(!daoUser.loginHandler(login)){
                    errorString = "Invalid login";
                    HttpSession session = request.getSession(true);
                    session.setAttribute("error", errorString);
                    request.getRequestDispatcher("/authorizationPage.jsp").forward(request, response);
                }
                else {
                    Auth user = daoUser.login(login, password);
                    if(user != null){

                        HttpSession session = request.getSession(true);
                        session.setAttribute("user", user);
                        request.getRequestDispatcher("/mainPage.jsp").forward(request, response);

                    }
                    else {
                        errorString = "Invalid password";
                        HttpSession session = request.getSession(true);
                        session.setAttribute("error", errorString);
                        request.getRequestDispatcher("/authorizationPage.jsp").forward(request, response);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
