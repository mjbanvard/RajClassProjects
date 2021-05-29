<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<h1>User Login</h1>

<form action="#" onsubmit="return validate()">
<table>
	<tr>
		<td>Username:</td>
		<td><input type="text" name="username" id="username"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="password"></td>
	</tr>
</table>
<input type="submit" value="Submit"><a href="home.jsp"
</form>




</body>
<script src="javaScript/settings.js"></script>
</html>