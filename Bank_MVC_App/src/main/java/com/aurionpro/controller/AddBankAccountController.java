package com.aurionpro.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.data.BankMvcAppDB;
import com.aurionpro.entity.Customer;

@WebServlet("/addBankAccount")
public class AddBankAccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddBankAccountController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BankMvcAppDB bankmvcdb = new BankMvcAppDB();
        String action = request.getParameter("action");

        if ("showRecent".equals(action)) {
            List<Customer> recentCustomers = bankmvcdb.getRecentCustomers();
            request.setAttribute("recentCustomers", recentCustomers);
        }

        String customerId = request.getParameter("customerId");
        if (customerId != null && !customerId.isEmpty()) {
            try (ResultSet resultset = bankmvcdb.getCustomerById(customerId)) {
                if (resultset != null && resultset.next()) {
                    request.setAttribute("firstName", resultset.getString("customerFName"));
                    request.setAttribute("lastName", resultset.getString("customerLName"));
                    request.setAttribute("email", resultset.getString("emailId"));

                    String existingAccountNumber = bankmvcdb.getAccountByCustomerId(customerId);
                    request.setAttribute("accountNumber", existingAccountNumber);
                    request.setAttribute("showAccountButton", existingAccountNumber == null);
                } else {
                    request.setAttribute("errorMessage", "No customer found with ID: " + customerId);
                }
            } catch (SQLException e) {
                request.setAttribute("errorMessage", "Error fetching customer data: " + e.getMessage());
            }
        }

        request.getRequestDispatcher("addBankAccount.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        BankMvcAppDB bankmvcdb = new BankMvcAppDB();

        if (customerId != null && !customerId.isEmpty()) {
            String newAccountNumber = bankmvcdb.generateAccountNumber();
            boolean isAccountAdded = bankmvcdb.addAccountForCustomer(customerId, newAccountNumber);

            request.setAttribute("message", isAccountAdded 
                ? "Account successfully added for customer ID: " + customerId 
                : "Failed to add account for customer ID: " + customerId);
        } else {
            request.setAttribute("errorMessage", "Customer ID is missing.");
        }

        request.getRequestDispatcher("addBankAccount.jsp").forward(request, response);
    }
}
