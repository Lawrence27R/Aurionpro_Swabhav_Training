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

@WebServlet("/ViewPassbookController")
public class ViewPassbookController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String customerAccountNum = (String) session.getAttribute("customerAccountNum");

        if (customerAccountNum == null) {
            request.setAttribute("errorMessage", "You must be logged in to view transactions.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Get filter parameters
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String typeOfTrans = request.getParameter("typeOfTrans");

        BankMvcAppDB bankDb = new BankMvcAppDB();
        bankDb.connectToDb(); // Establish the connection

        try {
            // Fetch transactions for the logged-in customer's account number with filters
            ResultSet transactions = bankDb.getFilteredTransactions(customerAccountNum, startDate, endDate, typeOfTrans);
            request.setAttribute("transactions", transactions);
            request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while retrieving transactions: " + e.getMessage());
            request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
        } finally {
            bankDb.closeConnection(); // Ensure the connection is closed
        }
    }
}
