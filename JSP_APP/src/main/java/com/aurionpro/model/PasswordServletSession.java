package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PasswordServletSession")
public class PasswordServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PasswordServletSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();

	    String password = request.getParameter("password");

	    HttpSession session = request.getSession();
	    String username = (String) session.getAttribute("username");

	    writer.print("Username: " + username + "<br>");
	    writer.print("Password: " + password);
	    
		    writer.print("<br><br>");
		    writer.print("<form> <Button>Logout</Button>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
