<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.galaxe.jspfs.vo.UserVO" %>
<%@ page import="java.net.URI" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<h1>User Login</h1>

<form action="validate.jsp" method="">

<table>
	<tr>
		<td>Username:</td>
		<td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="password"></td>
	</tr>
</table>
<input type="submit" value="Submit">

</form>

</body>
</html>