<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2020
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/create_customer">Create new customer</a>
<h1>Customers</h1>
<table border="1">
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td><a href="/edit_customer/${customer.id}">Edit</a></td>
            <td><a href="/delete_customer/${customer.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
