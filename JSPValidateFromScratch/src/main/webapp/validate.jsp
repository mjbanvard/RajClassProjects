<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.galaxe.jspfs.service.LoginValidation" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validate Invisible page</title>
</head>
<body>
Can we see anything?

<%
	String dest;
	LoginValidation lv = new LoginValidation();
	String username = (String)request.getParameter("username");
	String password = (String)request.getParameter("password");
	out.print(username + " " + password);
	
	if (lv.isValid(username, password)) {
		
		dest = "userSuccess.jsp";
	} else {
		dest = "error.jsp";
	}
	out.print(dest);

%>

<jsp:forward page = "<%= dest %>"></jsp:forward>
</body>
</html>