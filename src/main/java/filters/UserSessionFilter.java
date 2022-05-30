package filters;

import Models.Auth;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserSessionFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();

        Auth user = (Auth) session.getAttribute("user");
        String command = httpServletRequest.getParameter("command");

        if(user == null && !(command == null || command.equals("main")
                || command.equals("authorization") || command.equals("registration"))){
            System.out.println("UserSession");
            httpServletResponse.sendRedirect("http://localhost:8080/lab5_1_war/?command=main");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
