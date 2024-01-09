<%@page import="app.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employee</title>
</head>
<body>
	<h1>View Employee</h1>
	<table border="1">
		<tr>
			<th> Employee ID </th>
			<th> First Name </th>
			<th> Last Name </th>
			<th> Actions </th>
		</tr>

		<%
		List<Employee> emplist = (List) request.getAttribute("emplist");

		for (Employee employee : emplist) {
		%>
		<tr>
			<td><%=employee.getEmpid() %></td>
			<td><%=employee.getFirstname() %></td>
			<td><%=employee.getLastname() %></td>
			<td>
			<a href="update?id=<%=employee.getEmpid() %>"> Update </a> | 
			<a href="delete?id=<%=employee.getEmpid() %>"> Delete </a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>