package com.aurionpro.controller;

import com.aurionpro.data.BankMvcAppDB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/viewCustomers")
public class ViewCustomersController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortBy = request.getParameter("sortBy");
        String searchName = request.getParameter("searchName");
        String viewAll = request.getParameter("viewAll");

        BankMvcAppDB bankmvcdb = new BankMvcAppDB();
        try {
            ResultSet resultset = "true".equals(viewAll) ? 
                bankmvcdb.getAllCustomers(null, null) : 
                bankmvcdb.getAllCustomers(sortBy, searchName);

            request.setAttribute("customers", resultset);
            request.getRequestDispatcher("/viewCustomers.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error retrieving customer data: " + e.getMessage());
            request.getRequestDispatcher("/viewCustomers.jsp").forward(request, response);
        } finally {
            bankmvcdb.closeConnection();
        }
    }
}
