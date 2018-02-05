package by.epam.training.kazieva.controller;

import by.epam.training.kazieva.command.ActionCommand;
import by.epam.training.kazieva.command.factory.ActionFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class Controller extends HttpServlet {
    private static final String PATH_PAGE_LOGIN = "/jsp/login.jsp" ;
    private static final String PATH_REDIRECT_URL="redirect_ulr";
    private static final String PATH_REDIRECT = "redirect";
    private static final String TRUE = "true";
    private static final String COMMAND ="command";
    private static final String USER_ROLE="user_role";


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        HttpSession session = request.getSession(false);
        String user_role=(String)session.getAttribute(USER_ROLE);
        String action = request.getParameter(COMMAND);
     /*   request.getSession().setAttribute("lang", "ru");
        System.out.println(request.getRequestURI());*/
        if("login".equals(action)) {
            try {
                page = command.execute(request);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            if ((user_role+" role").equals("null role")) {
                page = PATH_PAGE_LOGIN;
            } else {
                try {
                    page = command.execute(request);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        if(request.getAttribute(PATH_REDIRECT)==TRUE){
            response.sendRedirect(request.getAttribute(PATH_REDIRECT_URL).toString());
        }
        else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }
}
