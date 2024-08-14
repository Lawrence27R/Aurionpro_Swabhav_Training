package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.data.BankMvcAppDB;

@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddCustomerController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer adminId = (Integer) session.getAttribute("adminId");
        
        if (adminId == null) {
            response.sendRedirect("loginPage.jsp");
            return;
        }

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        BankMvcAppDB bankmvcdb = new BankMvcAppDB();
        boolean isCustomerAdded = bankmvcdb.addCustomer(firstname, lastname, email, password, adminId);

        if (isCustomerAdded) {
            response.sendRedirect("adminDashboard.jsp?section=addCustomer&success=true");
        } else {
            response.sendRedirect("adminDashboard.jsp?section=addCustomer&error=true");
        }
    }


}

