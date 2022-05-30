package controller;


import Connector.Exceptions.JDBCConnectionException;
import DAO.Exceptions.DAOException;
import controller.command.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = {"/"})
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public Map<String, command.Command> commands;

    public MainServlet() {
        super();
        this.commands = new HashMap<>();
    }

    @Override
    public void init() {
        command.Command[] commands = {
            new MainCommand(),
            new ShowAllFilmsCommand(),
                new ShowGoodFilmsCommand(),
                new GetFilmActorsFormCommand(),
                new GetFilmActorsResultCommand(),
                new AuthorizationCommand(),
                new RegistrationCommand(),
                new ShowMenuCommand(),
                new LogOutCommand(),
                new ChatCommand(),
                new GetFilmsIdCommand(),
        };
        for (command.Command c : commands) {
            this.commands.put(c.getPattern(), c);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            try {
                commands.get("main").doGet(request, response, this.getServletContext());
            } catch (JDBCConnectionException e) {
                e.printStackTrace();
            } catch (DAOException e) {
                e.printStackTrace();
            }
        } else if (commands.containsKey(command)) {
            try {
                commands.get(command).doGet(request, response, this.getServletContext());
            } catch (JDBCConnectionException e) {
                e.printStackTrace();
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            try {
                commands.get("main").doGet(request, response, this.getServletContext());
            } catch (JDBCConnectionException e) {
                e.printStackTrace();
            } catch (DAOException e) {
                e.printStackTrace();
            }
        } else if (commands.containsKey(command)) {
            try {
                commands.get(command).doPost(request, response, this.getServletContext());
            } catch (JDBCConnectionException e) {
                e.printStackTrace();
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
    }
}
