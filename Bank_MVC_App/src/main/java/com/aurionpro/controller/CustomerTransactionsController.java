package com.aurionpro.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.aurionpro.data.BankMvcAppDB;

@WebServlet("/customerTransactions")
public class CustomerTransactionsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("customerId") == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if not logged in
            return;
        }

        int customerId = (int) session.getAttribute("customerId");

        BankMvcAppDB bankDb = new BankMvcAppDB();
        try {
            ResultSet transactions = bankDb.getCustomerTransactions(customerId);
            request.setAttribute("transactions", transactions);
            request.getRequestDispatcher("customerTransactions.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error fetching transactions: " + e.getMessage());
            request.getRequestDispatcher("customerTransactions.jsp").forward(request, response);
        } finally {
            bankDb.closeConnection();
        }
    }
}
