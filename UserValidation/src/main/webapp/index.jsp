<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ page import="com.wolfshead2.vo.User" %>
<%@ page import="com.wolfshead2.service.UserCheck" %>
<%@ page import="java.net.URI" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<h1>User Login</h1>

<form action="/validate" method="get">

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
<p>



	</p>
	<br />



</body>
</html>