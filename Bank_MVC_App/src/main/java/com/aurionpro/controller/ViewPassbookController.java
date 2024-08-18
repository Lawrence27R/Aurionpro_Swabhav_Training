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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("customerAccountNum") == null) {
            response.sendRedirect("loginPage.jsp");
            return;
        }

        String customerAccountNum = (String) session.getAttribute("customerAccountNum");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String typeOfTrans = request.getParameter("typeOfTrans");

        BankMvcAppDB bankDb = new BankMvcAppDB();
        bankDb.connectToDb(); 

        try {
            ResultSet transactions = bankDb.getFilteredTransactions(customerAccountNum, startDate, endDate, typeOfTrans);
            request.setAttribute("transactions", transactions);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "An error occurred while retrieving transactions: " + e.getMessage());
        } finally {
            bankDb.closeConnection();
        }

        request.getRequestDispatcher("viewPassbook.jsp").forward(request, response);
    }
}
