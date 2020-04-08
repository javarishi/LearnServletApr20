package com.h2k.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.h2k.web.listener.Customer;

public class SessionServlet extends HttpServlet {

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletConfig config = getServletConfig(); // getting static data from app
		ServletContext context = getServletContext(); // setting attributes to tomcat
		
		String dbname = config.getInitParameter("DBName");
		// config.getInitParameterNames()
		context.setAttribute("DBName", dbname);
		
		PrintWriter out = resp.getWriter();
		out.println("<HTML><BODY>");
		out.println("<p> config.getInitParameter(\"DBName\") :: " + dbname + "</p>");
		HttpSession session = req.getSession(false);
		if(session == null) {
			out.println("<p>");
			out.println("Session was null before I created it");
			out.println("</p>");
		}
		session = req.getSession(); 
		session.setMaxInactiveInterval(300);
		out.println("<p> session.isNew() :: " + session.isNew() + "</p>");
		out.println("<p> session.getId() :: " + session.getId() + "</p>");
		out.println("<p> session.getCreationTime() :: " + session.getCreationTime() + "</p>");
		out.println("<p> session.getLastAccessedTime() :: " + session.getLastAccessedTime() + "</p>");
		out.println("<p> session.getMaxInactiveInterval() :: " + session.getMaxInactiveInterval() + "</p>");
		
		Customer cust = new Customer();
		cust.setFirstName("David");
		cust.setCustId("100");
		cust.setSsn("102392193");
		cust.setCreditCardInfo("230432094892304");
		
		session.setAttribute("customer100", cust);
		
		
		//session.invalidate();
		out.println("<p> session.invalidate() :: </p>");
		
		out.println("</BODY></HTML>");
	}
}
