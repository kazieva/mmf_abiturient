package by.epam.training.kazieva.controller;

import by.epam.training.kazieva.command.ActionCommand;
import by.epam.training.kazieva.command.factory.ActionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(name = "controller", urlPatterns = "/controller")
@WebServlet("/")
public class Controller extends HttpServlet {
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
        try {
            page = command.execute(request);
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }
}
