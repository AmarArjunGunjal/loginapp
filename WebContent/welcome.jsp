<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="welcome" action="welcome" method="post">
		<table
			style="background-color: #ff9999; margin-left: 20px; margin-left: 20px;">
			<tr>
				<td><h3 style="color: black;">Welcome To The Login Page!!!</h3></td>
			</tr>
		</table>
		<%
			HttpSession ses = request.getSession();
			ArrayList al = (ArrayList) ses.getAttribute("value");
			out.println("Name= " + al.get(0));
		%><br>
		<%
			out.println("Email-Id = " + al.get(1));
		%><br>
		<%
			out.println("Phone = " + al.get(2));
		%>


	</form>

</body>
</html>