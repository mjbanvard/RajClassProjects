<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2 text-align="center">Login Page</h2>

<form action="validate.jsp">

<table align="center">

<tr>
<td>User Name</td>
<td><input type="text" name="userName"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
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