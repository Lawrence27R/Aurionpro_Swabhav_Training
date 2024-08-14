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

@WebServlet("/addBankAccount")
public class AddBankAccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddBankAccountController() {
        super();
    }

    // Search request
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        BankMvcAppDB bankmvcdb = new BankMvcAppDB();

        if (customerId != null && !customerId.isEmpty()) {
            ResultSet resultset = null;
            try {
            	resultset = bankmvcdb.getCustomerById(customerId);

                if (resultset != null && resultset.next()) {
                    request.setAttribute("firstName", resultset.getString("customerFName"));
                    request.setAttribute("lastName", resultset.getString("customerLName"));
                    request.setAttribute("email", resultset.getString("emailId"));

                    // Check if the customer already has an account
                    String existingAccountNumber = bankmvcdb.getAccountByCustomerId(customerId);
                    if (existingAccountNumber != null) {
                        request.setAttribute("accountNumber", existingAccountNumber);
                        request.setAttribute("showAccountButton", false);
                    } else {
                        request.setAttribute("showAccountButton", true);
                    }
                } else {
                    request.setAttribute("errorMessage", "No customer found with ID: " + customerId);
                }
            } catch (SQLException e) {
                request.setAttribute("errorMessage", "Error fetching customer data: " + e.getMessage());
            } finally {
                try {
                    if (resultset != null && !resultset.isClosed()) {
                    	resultset.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        request.setAttribute("section", "addBankAccount");
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }

    // Handle account creation request
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        BankMvcAppDB db = new BankMvcAppDB();
        String accountNumber = null;
        
        if (customerId != null && !customerId.isEmpty()) {
            accountNumber = db.generateAccountNumber();
            boolean isAccountAdded = db.addAccountForCustomer(customerId, accountNumber);
            if (isAccountAdded) {
                request.setAttribute("accountNumber", accountNumber);
                request.setAttribute("showAccountButton", false);
            } else {
                request.setAttribute("errorMessage", "Failed to create account for the customer.");
            }
        }

        request.setAttribute("section", "addBankAccount");
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
}
