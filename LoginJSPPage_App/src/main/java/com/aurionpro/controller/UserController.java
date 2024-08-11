package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.database.UserDbUtil;
import com.aurionpro.entity.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;

       
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Connect to the database
		UserDbUtil userDbUtil = new UserDbUtil();
		userDbUtil.connectToUserDb();

		List<User> users = userDbUtil.getUsers();
//		System.out.println("User List: " + users);
		request.setAttribute("users", users);

//		request.setAttribute("users", users);
		
		dispatcher = request.getRequestDispatcher("userview.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
