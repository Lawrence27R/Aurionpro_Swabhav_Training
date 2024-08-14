package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.data.BankMvcAppDB;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        BankMvcAppDB bankmvcdb = new BankMvcAppDB();
        boolean isValid = false;

        if ("admin".equals(role)) {
            isValid = bankmvcdb.isAdminValid(username, password, request.getSession());
            if (isValid) {
                response.sendRedirect("adminDashboard.jsp");
            } else {
                request.setAttribute("error", true);
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            }
        } else if ("customer".equals(role)) {
            isValid = bankmvcdb.isCustomerValid(username, password, request.getSession());
            if (isValid) {
                response.sendRedirect("customerDashboard.jsp");
            } else {
                request.setAttribute("error", true);
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", true);
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
        }
    }
}
