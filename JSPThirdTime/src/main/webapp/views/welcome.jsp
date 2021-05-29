<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Demo</title>
</head>
 	<jsp:include page="header.jsp"></jsp:include>
	<h1>Welcome page from index</h1>
		<jsp:useBean id="obj" class="javaJunk.Calculator"> </jsp:useBean>
		
<%
	int num = obj.sqrt(10);
	out.println(num);
%>

<%
	try {
		int num1 = 1000 % 0;
	} catch (ArithmeticException e) {
		out.println("There are some Arithmetic exceptions");
	}

	out.println("I am done with Exceptions");
%>
 
 <%
 	String username = request.getParameter("username");
 	out.println(username);
 %>
 
<%= request.getParameter("appName") %>
 
 <%! 
 	String name = "Michael";
 %>
 
 <% 
 	out.println("My name is " + name);
 %>
 
 <%=
 	"my name is " + name
 %>
</html>