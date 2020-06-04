<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2020
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create customer</title>
</head>
<body>
<h1>Create customer</h1>
<p>
    <a href="/customers">Customer list</a>
</p>
<div>
    <c:if test="${message != null}">
        <p>${message}</p>
    </c:if>
</div>
<form:form action="/create_customer" method="post" modelAttribute="customer">
    <table>
        <tr>
            <td><form:label path="firstName">First name</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Create customer"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
