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
        <th>Customer type</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerBirthday}</td>
            <c:if test="${customer.customerGender == 0}">
                <td>Male</td>
            </c:if>
            <c:if test="${customer.customerGender == 1}">
                <td>Female</td>
            </c:if>
            <td>${customer.customerIdCard}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerMail}</td>
            <td>${customer.customerAddress}</td>
            <c:forEach items="${customerTypeList}" var="customerType">
                <c:if test="${customerType.customerTypeId==customer.customerTypeId}">
                    <td>${customerType.customerTypeName}</td>
                </c:if>
            </c:forEach>
            <td><a href="/customer?action=edit&id=${customer.getCustomerId()}">edit</a></td>
            <td>
                <button type="button" class="btn btn-primary"
                        onclick="infoDelete('${customer.getCustomerId()}','${customer.getCustomerName()}')"
                        data-bs-toggle="modal" data-bs-target="#exampleModal"> Delete
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/customer" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="id" id="idDelete">
                    <input type="text" hidden name="action" value="delete">
                    <span>Bạn có muốn xóa khách hàng : </span>
                    <span id="nameDelete"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function infoDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
</body>
</html>
