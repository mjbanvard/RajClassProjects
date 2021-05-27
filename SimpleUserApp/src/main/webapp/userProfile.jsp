<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.wolfshead.vo.User" %>
<%@ page import="com.wolfshead.service.UserList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wolfshead.service.UserInstance" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body bgcolor="cyan">

<%
	String username = (String)request.getParameter("username");
	User user = new UserInstance().createUser(username);
	
	%>
	
 <h2>Do you really want to update <% out.println(username); %></h2>
 
 <form action="/SimpleUserApp/update" method="put">
   <table style="with: 80%">
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstName" value="<%=user.getFirstName()%>" /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" value="<%=user.getLastName()%>" /></td>
    </tr>
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" value="<%=user.getUsername()%>" /></td>
    </tr>
    <tr>
     <td>Role</td>
     <td>
	     <select>
	     <!--	<c:forEach items="${listCategory}" var="category">
                <option value="${category.id}"
                    <c:if test="${category.id eq selectedCatId}">selected="selected"</c:if>
                    >
                    ${category.name}
                </option>
            </c:forEach> --> 
	     	
	      	<option value="Admin">Admin</option>
	     	<option value="User">User</option> 
	     </select>
	 </td>
    
    </tr>
   </table>
   <input type="button" value="BackToAdmin" onclick="back">
   <input type="submit" value="Submit">
</form>

</body>
</html>