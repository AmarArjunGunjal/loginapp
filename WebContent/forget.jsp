<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="forget" method="post">
		<table
			style="background-color: #ff9999; margin-left: 20px; margin-left: 20px;">
			<tr>
				<td>New Password:</td>
				<td><input type="text" name="password"
					placeholder="Enter New Password"></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="text" name="cpassword"
					placeholder="Enter Confirm Password"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" name="submit password"
					value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>