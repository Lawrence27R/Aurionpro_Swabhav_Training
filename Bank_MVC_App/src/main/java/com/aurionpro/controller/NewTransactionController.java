package com.aurionpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.data.BankMvcAppDB;

@WebServlet("/NewTransactionController")
public class NewTransactionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String transactionType = request.getParameter("transactionType");
        String amountStr = request.getParameter("amount");
        String debitType = request.getParameter("debitType");
        String receiverAccountNumStr = request.getParameter("receiverAccountNum");

        HttpSession session = request.getSession();
        String customerAccountNum = (String) session.getAttribute("customerAccountNum"); 

        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amountStr);
        System.out.println("Debit Type: " + debitType);
        System.out.println("Receiver Account Number: " + receiverAccountNumStr);
        System.out.println("Customer Account Number from Session: " + customerAccountNum);

        if (customerAccountNum == null) {
            request.setAttribute("errorMessage", "You must be logged in to perform a transaction.");
            forwardToForm(request, response);
            return;
        }

        double amount;
        String receiverAccountNum = customerAccountNum; 

        try {
            amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                request.setAttribute("errorMessage", "Amount must be greater than zero.");
                forwardToForm(request, response);
                return;
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid amount.");
            forwardToForm(request, response);
            return;
        }

        if ("debit".equals(transactionType) && "other".equals(debitType)) {
            receiverAccountNum = receiverAccountNumStr;
            if (receiverAccountNum == null || receiverAccountNum.isEmpty()) {
                request.setAttribute("errorMessage", "Invalid receiver account number.");
                forwardToForm(request, response);
                return;
            }
        }

        BankMvcAppDB bankDb = new BankMvcAppDB();
        bankDb.connectToDb(); 

        try {
            boolean success = false;
            switch (transactionType) {
                case "credit":
                    success = bankDb.creditAmount(customerAccountNum, amount);
                    if (!success) {
                        request.setAttribute("errorMessage", "Transaction failed.");
                    } else {
                        request.setAttribute("successMessage", "Credit transaction successful.");
                    }
                    break;
                case "debit":
                    if ("self".equals(debitType)) {
                        success = bankDb.debitAmount(customerAccountNum, amount);
                    } else {
                        success = bankDb.transferAmount(customerAccountNum, amount, receiverAccountNum);
                    }
                    if (!success) {
                        request.setAttribute("errorMessage", "Insufficient balance or transaction failed.");
                    } else {
                        request.setAttribute("successMessage", "Debit transaction successful.");
                    }
                    break;
                default:
                    request.setAttribute("errorMessage", "Invalid transaction type.");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred during the transaction: " + e.getMessage());
        } finally {
            bankDb.closeConnection(); 
        }

        forwardToForm(request, response);
    }

    private void forwardToForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("newTransaction.jsp").forward(request, response);
    }
}
