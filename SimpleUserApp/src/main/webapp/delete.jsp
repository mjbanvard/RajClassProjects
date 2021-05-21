<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.wolfshead.vo.User" %>
<%@ page import="com.wolfshead.service.UserInstance" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Page</title>
</head>
<body bgcolor="pink">

<%
	String username = (String)request.getParameter("username");
	UserInstance ui = new UserInstance();
	User user = ui.createUser(username);
	
	%>
	
 <h2>Do you really want to delete <% out.println(username); %></h2>
 
 <form>
 <input type="reset" value="Cancel" />
 <input type="submit" value="Delete" />
 </form>
 
<!--  	Yes or No
 		If Yes, the implement "DELETE FROM user WHERE username = "userName"
  -->
  
</body>
</html>