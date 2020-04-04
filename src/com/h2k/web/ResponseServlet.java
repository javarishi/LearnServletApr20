package com.h2k.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		Cookie cookieOne = new Cookie("SampleCookie", "SampleValue");
		cookieOne.setMaxAge(3600);
		Cookie cookieTwo = new Cookie("SampleCookie2", "SampleValue2");
		// Adding a Cookie
		resp.addCookie(cookieOne);
		resp.addCookie(cookieTwo);
		out.println("Cookie set in Response");
		// MIME Type - text/HTML application/pdf
		resp.setContentType("text/HTML");
		resp.setContentLength(128);
		out.println("Content added");
	//	resp.setBufferSize(256);
	//	resp.flushBuffer();
	
		
	}

}
