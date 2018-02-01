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
        String user_role=(String)session.getAttribute("user_role");
        String action = request.getParameter("command");
        if("login".equals(action)) {
            try {
                page = command.execute(request);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            if (!(user_role+" role").equals("null role")) {
                try {
                    page = command.execute(request);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                page = PATH_PAGE_LOGIN;
            }
        }

        if (page != null) {
            if ("login".equals(action)||"add_abiturient".equals(action)||"delete_abiturient".equals(action)||"update_abiturient".equals(action)){
                response.sendRedirect("Controller?command=result");
            }else{
            if("delete_speciality".equals(action)||"add_speciality".equals(action)){
                response.sendRedirect("Controller?command=result_speciality");
            }else{
            if("registration".equals(action)||"update_user_role".equals(action)){
                response.sendRedirect("Controller?command=all_users");
            }
            else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
                dispatcher.forward(request, response);
            }}}
        }
    }
}
