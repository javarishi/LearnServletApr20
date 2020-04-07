package com.h2k.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.h2k.web.util.UserValidation;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(UserValidation.validateUser(userName, password)) {
			chain.doFilter(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("LogicFilter :: Invalid User");
			response.flushBuffer();
		}

	}
}
