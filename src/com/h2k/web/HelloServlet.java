package com.h2k.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * http://localhost:8080/LearnServletApr20/hello
 * Sysout Hello in Console
 */
public class HelloServlet extends HttpServlet {
	
	// Birth of Servlet - init
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Init - Called only once");
	}

	// Service - Serve HTTP methods - GET, POST, PUT, HEAD, TRACE 
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// resp = HttpServletResponse
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		
		// Cookie - 
		
		// Webserver sending static information to Application
		ServletConfig config = getServletConfig();
		// Application want to set information to WebServre
		ServletContext context = getServletContext();
		
		out.println("<HTML><BODY>");
		// req - HttpServletRequest 
		String paramValue = req.getParameter("name");
		out.println("Received :: " + paramValue);
		
		Enumeration<String> paramNames = req.getParameterNames();
		String param = null;
		while(paramNames.hasMoreElements()) {
			param = paramNames.nextElement();
			out.println("<p>");
			out.println("Received :: " + param + " With Value " + req.getParameter(param) );
			out.println("</p>");
		}
		
		
		Enumeration<String> headerNames = req.getHeaderNames();
		String header = null;
		while(headerNames.hasMoreElements()) {
			header = headerNames.nextElement();
			out.println("<p>");
			out.println("Header Received :: " + header + " With Value " + req.getHeader(header) );
			out.println("</p>");
		}
		
		// getting attribute
		out.println("<p> Customer Name Attribute Value :: " + req.getAttribute("custName") + " </p>");
		// getting attribute
		out.println("<p> Customer ZipCode Attribute Value :: " + session.getAttribute("custZipCode") + " </p>");
		
		out.println("</BODY></HTML>");

		
	}
	
	@Override
	public void destroy() {
		System.out.println("HelloServlet destroy ");
	}
}
