package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    String username = request.getParameter("username");
	    
	    // Create and add the cookie to the response
	    Cookie cookie = new Cookie("username", username);
	    response.addCookie(cookie);

	    PrintWriter writer = response.getWriter();

	    // Generate the form for the password
	    writer.print("<form action='PasswordServlet' method='get'>");
	    writer.print("Password: <input type='password' name='password'>");
	    writer.print("<button type='submit'>Submit</button>");
	    writer.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
