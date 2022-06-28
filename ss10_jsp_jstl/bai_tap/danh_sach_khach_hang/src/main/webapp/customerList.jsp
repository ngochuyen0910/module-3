<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ngọc Mai
  Date: 6/28/2022
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<table border="1px"; border-collapse:collapse ; width="100%" >
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Day Of Birth</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.dayOfBirth}</td>
            <td>${customer.address}</td>
            <td><img src="${customer.image}" width="100" height="100" alt=""></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
