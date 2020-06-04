<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2020
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete customer</title>
</head>
<body>
<h1>Delete customer</h1>
<h1>Are you sure?</h1>
<div>
    <c:if test="${message != null}">
        <p>${message}</p>
    </c:if>
</div>
<form:form action="/delete_customer" method="post" modelAttribute="customer">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td><form:label path="firstName">${customer.firstName}</form:label></td>
        </tr>
        <tr>
            <td><form:label path="lastName">${customer.lastName}</form:label></td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete customer"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
