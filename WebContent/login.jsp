<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	color: black;
	font-size: 10px;
}
</style>
</head>
<body>
	<form name="form" action="Login" method="post">
		<table
			style="background-color: #ff9999; margin-left: 20px; margin-left: 20px;">
			<tr>
				<td><h3 style="color: red;">Login Page!!!</h3></td>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="name" placeholder="Enter Name"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					placeholder="Enter Password"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="reset" name="clear"
					value="Reset"> <input type="submit" name="submit"
					value="Login"></td>
			</tr>
			<tr>
				<td><a href="forgot.jsp">Forget Password</a></td>
				<td align="right"><a href="register.jsp">Register</a></td>
			</tr>
		</table>
	</form>
</body>
</html>