package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.aurionpro.data.BankMvcAppDB;

@WebServlet("/EditProfileController")
public class EditProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int customerId = (Integer) session.getAttribute("customerId");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        BankMvcAppDB db = new BankMvcAppDB();
        boolean isUpdated = db.updateCustomerProfile(customerId, firstName, lastName, email, password);

        if (isUpdated) {
            response.sendRedirect("editProfile.jsp?updateSuccess=true");
        } else {
            response.sendRedirect("editProfile.jsp?updateFailed=true");
        }
    }
}
