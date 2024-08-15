package com.aurionpro.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.data.BankMvcAppDB;
import com.aurionpro.entity.Transaction;

@WebServlet("/customerTransactions")
public class CustomerTransactionsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("customerAccountNum") == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if not logged in
            return;
        }

        String customerAccountNum = (String) session.getAttribute("customerAccountNum");

        BankMvcAppDB bankDb = new BankMvcAppDB();
        List<Transaction> transactionList = new ArrayList<>();
        try {
            ResultSet transactions = bankDb.getCustomerTransactions(customerAccountNum);
            while (transactions.next()) {
                Transaction transaction = new Transaction(
                    transactions.getString("senderAccNum"),
                    transactions.getString("receiversAccNum"),
                    transactions.getString("typeOfTrans"),
                    transactions.getDouble("amount"),
                    transactions.getDate("date")
                );
                transactionList.add(transaction);
            }
            request.setAttribute("transactions", transactionList);
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
