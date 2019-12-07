<%@page import="com.lti.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	
	Customer c=(Customer) session.getAttribute("customer");
%>
	<%= c.getId() %><br />
	<%= c.getName() %><br />
	<%= c.getEmail() %><br />
	<%= c.getCity() %><br />
	
		
</body>
</html>