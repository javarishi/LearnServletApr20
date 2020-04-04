package com.h2k.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setAttribute("testRd", "test RD Value");
		
		// RequestDispatcher rd = req.getRequestDispatcher("req");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/req");
		rd.forward(req, resp);

	}
}
