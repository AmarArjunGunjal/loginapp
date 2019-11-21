<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Registration" method="Post">

<table style ="background-color:#ff9999; margin-left:20px;margin-left: 20px;" >
<tr>
<td>  <h3 style = "color: black;"> Registration Page!!!</h3></td>
</tr>
<tr>
	<td>Name:</td>
	<td><input type="text" name="name" placeholder="Enter the username" required></td>
</tr>
<tr>
	<td>Phone:</td>
	<td><input type="text" name="phoneno" placeholder="Enter the phone no" required></td>
</tr>
<tr>
	<td>EmailId:</td>
	<td><input type="text" name="email" placeholder="Enter the email" required max="10"></td>
</tr>
<tr>
	<td>Password:</td>
	<td><input type="password" name="password" placeholder="Enter the password" required></td>
</tr>
<tr>
	<td>Retype Password:</td>
	<td><input type="password" name="rpassword" placeholder="Enter the password" required></td>
</tr>
<tr>
<td >  </td>
<td> <input type="submit" name="submit" value="Register">
	 <input type="reset" name="clear" value="Clear"> 
	 <input type="button" value="Cancel" onclick="location.href='login.jsp'"> </td>
<tr>
</table>

</form>
</body>
</html>