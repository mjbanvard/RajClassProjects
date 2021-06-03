<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URI"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>


	<h1>Employee Registration Form</h1>

	<form action="<%=request.getContextPath()%>/EmployeeRegistration"
		method="post">
		
		<table align="center">

			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName"></td>

			</tr>

			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"></td>
			</tr>

			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="text" name="password"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="email" name="email"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>


		</table>


	</form>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>