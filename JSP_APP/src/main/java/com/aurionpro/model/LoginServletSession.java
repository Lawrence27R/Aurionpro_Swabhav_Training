package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServletSession")
public class LoginServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServletSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    String username = request.getParameter("username");
	    
	    // Session
	    HttpSession session = request.getSession();
	    session.setAttribute("username", username);

	    PrintWriter writer = response.getWriter();

	    writer.print("<form action='PasswordServletSession' method='post'>");
	    writer.print("Password: <input type='password' name='password'>");
	    writer.print("<button type='submit'>Submit</button>");
	    writer.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
