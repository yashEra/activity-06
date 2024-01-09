<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
<h1>Edit Employee</h1>
<jsp:useBean id="emp" class="app.entity.Employee" scope="request"></jsp:useBean>
<form action="update" method="post">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="empid" value="<%=emp.getEmpid() %>" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname" value="<%=emp.getFirstname() %>"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" value="<%=emp.getLastname() %>"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
</body>
</html>