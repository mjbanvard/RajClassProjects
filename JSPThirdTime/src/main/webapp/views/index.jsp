<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<h1>Welcome to the jsp page</h1>
	
	<form method="post" action = "views/welcome.jsp">
		<input type="hidden" name="appName value="GxTraining" />

		username: <input type="text" name="username" />
		password: <input type="password" />
		<input type="submit" />
	</form>

</body>
</html>