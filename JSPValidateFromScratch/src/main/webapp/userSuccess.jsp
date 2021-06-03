<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.galaxe.jspfs.vo.UserVO"%>
<%@ page import="com.galaxe.jspfs.service.UserService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Validated</title>
</head>
<body align="center">
	<jsp:include page="header.jsp"></jsp:include>

	<h1>Patient Portal</h1>

	<sql:setDataSource var="myDB" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/jdbc_practice" user="recipe_user"
		password="root%recipe5" />

	<sql:query var="userRS" dataSource="${myDB}">
        SELECT * FROM user
    </sql:query>

	<table style="width: 50%" align="center" border="1">
		<tr>
			<TH>First Name</th>
			<TH>Last Name</th>
			<TH>Username</th>
			<TH>E-mail</TH>
		</tr>

		<c:forEach var="user" items="${userRS.rows}">
			<tr>
				<td><c:out value="${user.firstName}" /></td>
				<td><c:out value="${user.lastName}" /></td>
				<td><c:out value="${user.username}" /></td>
				<td><c:out value="${user.email}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />


	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>