<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<%
	String uName = (String) session.getAttribute("username");
	%>
	
	<p align="center">
	<h1>
		Welcome<%
	if (uName != null) {out.print(", " + uName + ", ");}
		%>
		to our Office Home Page!
	</h1>
	</p>

	<table style="width: 100%; align: center" border="1">
		<tr>
			<td><a href="aboutUs.jsp">About Us</a></td>
			<td><a href="contactUs.jsp">Contact Us</a></td>
			<td><a href="services.jsp">Services</a></td>
			<td><a href="logout.jsp">Logout</a></td>
		</tr>

	</table>

</body>
</html>