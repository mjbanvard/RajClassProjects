<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gx-Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="/JustForDemo/Login" method="get">
	<p><%= request.getAttribute("error") %></p>
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" id="userid"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="passid"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>