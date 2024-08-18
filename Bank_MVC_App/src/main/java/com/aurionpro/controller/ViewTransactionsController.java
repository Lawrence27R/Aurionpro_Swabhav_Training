package com.aurionpro.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aurionpro.data.BankMvcAppDB;

@WebServlet("/ViewTransactions")
public class ViewTransactionsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BankMvcAppDB db = new BankMvcAppDB();
        ResultSet transactions = null;

        try {
            String filterType = request.getParameter("type");
            String filterDate = request.getParameter("date");

            if (filterType != null && !filterType.isEmpty()) {
                transactions = db.getTransactionsByType(filterType);
            } else if (filterDate != null && !filterDate.isEmpty()) {
                transactions = db.getTransactionsByDate(filterDate);
            } else {
                transactions = db.getAllTransactions();
            }

            request.setAttribute("transactions", transactions);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error retrieving transactions: " + e.getMessage());
        } finally {
            db.closeConnection();
        }

        request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
    }
}
