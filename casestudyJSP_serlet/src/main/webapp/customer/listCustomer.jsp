<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Customer List</h1>
<p>
    <a href="/customer?action=create">Create new customer</a>
</p>
<table class="table" id="tableData">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Gender</th>
        <th>Id card</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Address</th>
        <th>Customer type id</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerBirthday}</td>
            <td>${customer.customerGender}</td>
            <td>${customer.customerIdCard}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerMail}</td>
            <td>${customer.customerAddress}</td>
            <td>${customer.customerTypeId}</td>
            <td><a href="/customer?action=edit&id=${customer.getCustomerId()}">edit</a></td>
            <td><a href="/customer?action=delete&id=${customer.getCustomerId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

</body>
</html>
