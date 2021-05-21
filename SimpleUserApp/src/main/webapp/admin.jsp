<%@ page import="com.wolfshead.db.DbConnection" %>
<%@ page import="com.wolfshead.vo.User" %>
<%@ page import="com.wolfshead.service.UserList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Connection" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Admin</title>
</head>
<body bgcolor="green">

<h2>This is where we do all of the work on all of the Users.</h2>

<% List<User> userList = (ArrayList<User>)request.getAttribute("userList"); 
	%>

 <table border="1">
   <tr>
      <TH>User Id</th>
      <TH>First Name</th>
      <TH>Last Name</th>
      <TH>User Name</th>
      <th>Update</th>
      <th>Delete</th>
    </tr> 
      <c:forEach items="${userList}" var="user">
        <tr>
          <td><c:out value="${user.id}" /></td>
          <td><c:out value="${user.firstName}" /></td>
          <td><c:out value="${user.lastName}" /></td>
          <td><c:out value="${user.username}" /></td>
          
          <td><a href="/SimpleUserApp/userProfile.jsp?username=${user.username}">Update</a></td>
          <td><a href="/SimpleUserApp/delete.jsp?username=${user.username}">Delete</a></td>
        </tr>
      </c:forEach>
    </table>

</body>
</html>