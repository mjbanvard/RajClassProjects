<%@ page import="com.wolfshead.vo.User" %>
<%@ page import="java.sql.ResultSet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User View</title>
</head>
<body bgcolor="yellow">

<%
	User user = (User)request.getAttribute("user");
	//out.println(user.toString());
	//out.println("User ID = " + user.getId());
	//out.println("User Name = " + user.getFirstName() + " " + user.getLastName());
	//out.println("User Role = " + user.getRole()); 
	
	%>
 <h2>Welcome home, <c:out value="${user.firstName}"></c:out></h2>





This will be a static web page, displaying the User info.

 <table border="1">
   <tr>
      <TH>User Id</th>
      <TH>First Name</th>
      <TH>Last Name</th>
      <TH>Username</th>
      <TH>Role</TH>
    </tr> 
      
        <tr>
          <td><c:out value="${user.id}" /></td>
          <td><c:out value="${user.firstName}" /></td>
          <td><c:out value="${user.lastName}" /></td>
          <td><c:out value="${user.username}" /></td>
          <td><c:out value="${user.role}" /></td>
        </tr>
      
    </table>


</body>
</html>