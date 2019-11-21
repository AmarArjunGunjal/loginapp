<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form id="myForm" action="Forgot Password" method="post">
		<table
			style="background-color: #ff9999; margin-left: 20px; margin-left: 20px;">
			<tr>
				<td>
					<h3 style="color: black">Forget Password</h3>
				</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"
					placeholder="Enter Email Here"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="reset" name="clear"
					value="Reset"> <input type="submit" name="check"
					value="Check"></td>
			</tr>
		</table>
	</form>

</body>
</html>