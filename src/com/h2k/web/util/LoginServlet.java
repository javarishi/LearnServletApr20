package com.h2k.web.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<HTML><BODY>");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		// username = rishi password = pass@rishi
		String message = null;
		if(UserValidation.authenticateUser(userName, password)) {
			message = "User is Valid";
		}else {
			message = "Invalid Credentials";
		}
		out.println("<p>" + message + " </p>");
		out.println("</BODY></HTML>");
	}
}
