package com.h2k.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.h2k.web.listener.Customer;

public class RequestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<HTML><BODY>");
		// Taking Request Parameters
		Enumeration<String> paramNames = req.getParameterNames();
		String param = null;
		while(paramNames.hasMoreElements()) {
			param = paramNames.nextElement();
			out.println("<p>");
			out.println("Received :: " + param + " With Value " + req.getParameter(param) );
			out.println("</p>");
		}
		
		// Reading Header information from Request
		Enumeration<String> headerNames = req.getHeaderNames();
		String header = null;
		while(headerNames.hasMoreElements()) {
			header = headerNames.nextElement();
			out.println("<p>");
			out.println("Header Received :: " + header + " With Value " + req.getHeader(header) );
			out.println("</p>");
		}
		
		// getting cookies from request
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie eachCookie : cookies) {
				out.println("<p>");
				out.println("Cookie Received :: " + eachCookie.getName() + " With Value " +  eachCookie.getValue());
				out.println("</p>");
			}
		}
		
		out.println("<p> Setting and Getting Request Attributes:: </p>");
		// Attributes
		req.setAttribute("custName", "David Nix");
		// getting attribute
		out.println("<p> Customer Name Attribute Value :: " + req.getAttribute("custName") + " </p>");
		out.println("<p> testRd Attribute Value :: " + req.getAttribute("testRd") + " </p>");
		// Session
		out.println("<p> Setting and Getting Session Attributes:: </p>");
		HttpSession session = req.getSession();
		session.setAttribute("custZipCode", "30080");
		out.println("<p> session.getMaxInactiveInterval() :: " + session.getMaxInactiveInterval() + "</p>");
		// getting attribute from Session
		out.println("<p> Customer ZipCode Attribute Value :: " + session.getAttribute("custZipCode") + " </p>");
		// getting attribute from Context
		out.println("<p> Context Attribute Value for DBName:: " + getServletContext().getAttribute("DBName") + " </p>");
		Customer cust = (Customer) session.getAttribute("customer100");
		System.out.println(cust);
		session.removeAttribute("customer100");
		
		out.println("<p> Customers LocalAddr  :: " + req.getLocalAddr()+ " </p>");
		out.println("<p> Customers RemoteAddr :: " + req.getRemoteAddr() + " </p>");
		out.println("</BODY></HTML>");
	}

}
