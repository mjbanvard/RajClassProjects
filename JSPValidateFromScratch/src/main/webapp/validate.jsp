<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.classroom.service.LoginValidation"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validate Invisible page</title>
</head>
<body>

	<%
	String dest;
	LoginValidation lv = new LoginValidation();
	String username = (String)request.getParameter("userName");
	String password = (String)request.getParameter("password");
	out.print(username + " " + password);
	
	if (lv.isValid(username, password)) {
		dest = "userSuccess.jsp";
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		out.println("Validation is good.");
	} else {
		dest = "error.jsp";
		out.println("No foood!");
	}
	out.print(dest);

%>

	<jsp:forward page="<%= dest %>"></jsp:forward>
</body>
</html>