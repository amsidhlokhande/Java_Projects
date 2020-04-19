<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<div align="center">
	<h2>Add User Data</h2>
	<form:form action="register" method="POST" modelAttribute="user">
		<table align="center">
			<tr>
				<td><form:label path="username">User Name</form:label></td>
				<td><form:input path="username" value="${user.username}" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password :</form:label></td>
				<td><form:password path="password" value="${user.password}" /></td>
			</tr>

			<tr>
				<td><form:label path="isEnabled">User Enabled</form:label></td>
				<td><form:input path="isEnabled" value="${user.isEnabled}" /></td>
			</tr>

			<tr>
				<td><form:label path="userRole.role">User Role</form:label></td>
				<td><form:input path="userRole.role" value="${user.userRole.role}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${! empty users}">
		<table align="center" border="1">
			<tr bgcolor="pink">
				<th align="center">USER NAME</th>
				<th align="center">USER ENABLED</th>
				<th align="center">USER ROLE</th>

			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.isEnabled}</td>
					<td>${user.userRole.role}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="profile">Login</a>
 </div>	
 
</body>
</html>