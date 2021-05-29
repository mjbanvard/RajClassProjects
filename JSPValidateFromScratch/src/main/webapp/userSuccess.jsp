<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.galaxe.jspfs.vo.UserVO" %>
<%@ page import="com.galaxe.jspfs.service.UserService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Validated</title>
</head>
<body>

<h1>SUCCESS</h1>

<jsp:useBean id="user" class="com.galaxe.jspfs.vo.UserVO"></jsp:useBean>

<% String uName = (String)request.getParameter("username"); %>
<sql:setDataSource
        var="myDB"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/jdbc_practice"
        user="recipe_user"
        password="root%recipe5"
    />
     
    <sql:query var="user"   dataSource="${myDB}">
        SELECT * FROM user WHERE username = "${uName}";
    </sql:query>
    
 <table border="1">
   <tr>
      <TH>User Id</th>
      <TH>First Name</th>
      <TH>Last Name</th>
      <TH>Username</th>
      <TH>Role</TH>
    </tr> 
      
        <tr>
          <td><c:out value="${user.getId}" /></td>
          <td><c:out value="${user.firstName}" /></td>
          <td><c:out value="${user.lastName}" /></td>
          <td><c:out value="${user.username}" /></td>
          <td><c:out value="${user.role}" /></td>
        </tr>
      
    </table>




</body>
</html>