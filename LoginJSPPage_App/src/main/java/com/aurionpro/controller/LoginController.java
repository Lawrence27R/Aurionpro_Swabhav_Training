package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.database.UserDbUtil;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDbUtil userDbUtil = new UserDbUtil();

    public LoginController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDbUtil.connectToUserDb(); 

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String nextPage = "/LoginFailed.jsp"; 

        if (userDbUtil.validateCredentials(username, password)) {
            request.setAttribute("username", username);
            nextPage = "/LoginSuccess.jsp"; 
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
