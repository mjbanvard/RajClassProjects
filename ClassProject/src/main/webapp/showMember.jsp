<%@ page import="memberManagement.model.Member" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Member</title>
</head>
<body bgcolor="cyan">

<h1>Show Member</h1>

<form action="/ClassProject/get">
 <table>
  <tr>
    <th>Read a Record</th>
    <th><input type="text" name="memId">
    <!--   <th><input type="submit" name="memberDetails.jsp"> -->
  </tr>
  </table>
  </form> 

	<%
	Member member = (Member)request.getAttribute("member");
		
	out.println(member);
	%>

</body>
</html>