<%@ include file="/jsp1/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="pointincrease.heading"/></h1>

<form:form commandName="pointIncrease"  method="post" >
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Increase (Points):</td>
        <td width="20%">
          <form:input path="point" id="point" />
        </td>

    </tr>
  </table>
  <br>
  
  <input type="submit" name="submit" value="submit">
</form:form>

<a href="<c:url value="users.htm"/>">Home</a>

</body>
</html>