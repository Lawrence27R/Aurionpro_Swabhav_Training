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
        try {
            ResultSet transactions = db.getAllTransactions();
            if (transactions != null) {
                request.setAttribute("transactions", transactions);
            }
            request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

}
