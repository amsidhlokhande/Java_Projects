<%@ include file="/jsp1/include.jsp" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>USERS POINTS</h3><br><br>
    <c:forEach items="${model.users}" var="user">
      <c:out value="${user.name}"/>   ----   <c:out value="${user.points}"/><br><br>
    </c:forEach>
    
    <br>
    <a href="<c:url value="pointincrease.htm"/>">Increase Points</a>
    <br>
    
  </body>
</html>