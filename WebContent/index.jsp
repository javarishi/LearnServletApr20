<%@ page import="java.util.Date"%>
<%@ page language="java" 
		contentType="text/html; charset=ISO-8859-1"
   		pageEncoding="ISO-8859-1"
   		autoFlush="true"
   		buffer="8kb"
   		session="true"
   		isErrorPage="false"
   		errorPage="error.jsp"
   		info="Additional information about this JSP Page"
   		isThreadSafe="true"
   		isELIgnored="true"
   		%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome Page</title>
	</head>
<body>
	<!-- This is HTML Comment -->
	<h1>Hello H2K Students</h1>
	<%! int i = 10; %>
	<%-- This is called JSP Comment --%>
	<%
		out.println("Your IP Address is :: " + request.getRemoteAddr());
		out.println("Value declared for i is " + i);
	%>
	<p> 
		Today's date: <%= (new Date())%>
	</p>
	
	<ul>
		<li>1. out - PrintWriter</li>
		<li>2. request - HttpServletRequest</li>
		<li>3. response - HttpServletResponse</li>
		<li>4. session - HttpSession</li>
		<li>5. application - HttpServletContext</li>
		<li>6. config - HttpServletConfig</li>
		<li>7. page - Instance of JSP Page. Java "this" </li>
		<li>8. pageContext - Page Manager by Tomcat</li>
	</ul>
	
	<!--  Set an Attribute in All Scopes -->
	
	<%
		pageContext.setAttribute("requestKey", "requestValue", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("pageKey", "pageValue", PageContext.PAGE_SCOPE);
		pageContext.setAttribute("sessionKey", "sessionValue", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("contextKey", "contextValue", PageContext.APPLICATION_SCOPE);
		
		//RequestDispatcher rd = application.getRequestDispatcher("/hello");
		//rd.forward(request, response);
		
		response.sendRedirect("https://www.h2kinfosys.com");
	%>
	
	
	<%@ include file="footer.jsp" %>
</body>
</html>