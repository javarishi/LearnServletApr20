package com.h2k.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuditFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AuditFilter init ");
		filterConfig.getInitParameter("app_name");	
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, 
			FilterChain chain)
			throws IOException, ServletException {
		
		// Pre-processing Logic - work on request here
		System.out.println("AuditFilter :: PreProcessing Logic");
		System.out.println("Remote Address :: " + req.getRemoteAddr());
		chain.doFilter(req, resp); // accessing next filter in line - call Servlet instead
		// Post processing logic - work on response here
		System.out.println("AuditFilter :: Post processing logic");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("AuditFilter destroy ");
	}

}
