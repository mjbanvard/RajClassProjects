<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Individual</title>
<link rel="stylesheet" href="css/stylesheet.css" />
</head>
<body background="Scan_20170719(19).jpg">

<h1>Welcome to the home of the Banvard branch.</h1>

<h2 class="noodles">This is where you can add a family member.</h2>

<p class="textTraights">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut 
labore et dolore magna aliqua. Ipsum dolor sit amet consectetur adipiscing elit ut aliquam 
purus. 
</p>

<form action="#" onsubmit="validate()">
	<table align="center" width="50%">
		<tr>
			<td>First Name</td>
			<td><input type="text" /></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" /></td>
		</tr>
		<tr>
			<td>User Name</td>
			<td><input type="text" id="username"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>Male<input type="radio" name="gender" value="male"/> 
				Female<input type="radio" name="gender" value="female"/></td>
		</tr>
		<tr>
			<td>Known relations</td>
			<td>Mother<input type="checkbox" name="famMem" value="Mother"/> 
				Father<input type="checkbox" name="famMem" value="Father"/>
				Sister<input type="checkbox" name="famMem" value="Sister"/>
				Brother<input type="checkbox" name="famMem" value="Brother"/>
				Daughter<input type="checkbox" name="famMem" value="Daughter"/>
				Son<input type="checkbox" name="famMem" value="Son"/></td>
		</tr>
		<tr>
			<td>Family Branch</td>
			<td>
				<select name="famBranch">
				<option value="french">France</option>
				<option value="eastUS">Eastern US</option>
				<option value="westUS">Western US</option>
				<option value="other">Elsewhere</option>
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td align="left"><input type="submit"></td>
		</tr>
	</table>
	</form>

<span style="float:left"><a href="home.jsp">Home</a></span>
<span style="float:right"><a href="addHousehold.jsp">Add Household</a></span>

</body>

<script>
		function validate() {
			var name = document.getElementById("username").value;
			if (name != "" && name.length > 0) 
				return true;
			else {
				alert("Please enter your username");
				return false;
			}
		}
</script>
</html>