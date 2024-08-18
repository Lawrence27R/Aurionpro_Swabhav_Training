package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.data.BankMvcAppDB;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        BankMvcAppDB bankmvcdb = new BankMvcAppDB();
        HttpSession session = request.getSession();
        session.setAttribute("error", null);

        boolean validUser = false;

        if ("admin".equals(role)) {
            validUser = bankmvcdb.isAdminValid(username, password, session);
            if (validUser) {
                session.setAttribute("adminId", bankmvcdb.getAdminId(username));
                response.sendRedirect("adminDashboard.jsp");
                return;
            }
        } 

        if ("customer".equals(role)) {
            validUser = bankmvcdb.isCustomerValid(username, password, session);
            if (validUser) {
                response.sendRedirect("customerDashboard.jsp");
                return;
            }
        }

        request.setAttribute("error", true);
        request.getRequestDispatcher("loginPage.jsp").forward(request, response);
    }
}
