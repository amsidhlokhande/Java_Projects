<%@taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
  Hi <!--<sec:authentication property="principal.username"/> OR --> ${pageContext.request.userPrincipal.name} , ${message}
  </div>
  <c:url value="/j_spring_security_logout" var="logoutUrl" />
  <br>
  <h3 align="center"><a href="${logoutUrl}">Logout</a></h3> 
</body>
</html>