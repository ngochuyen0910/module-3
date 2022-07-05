<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Contract List</h1>
<p>
    <a href="/contract?action=create">Create new contract</a>
</p>
<table class="table" id="tableData">
    <tr>
        <th>Contract id</th>
        <th>Facility id</th>
        <th>Customer id</th>
        <th>Employee id</th>
        <th>Contract start date</th>
        <th>Contract end date</th>
        <th>Deposit</th>
        <th>Total money</th>
    </tr>
    <c:forEach items="${contractList}" var="contract">
        <tr>
            <td>${contract.contractId}</td>
            <c:forEach items="${facilityList}" var="facility">
                <c:if test="${facility.facilityId==contract.facilityId}">
                    <td>${facility.facilityName}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${customerList}" var="customer">
                <c:if test="${customer.customerId==contract.customerId}">
                    <td>${customer.customerName}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${employeeList}" var="employee">
                <c:if test="${employee.employeeId==contract.employeeId}">
                    <td>${employee.employeeName}</td>
                </c:if>
            </c:forEach>
            <td>${contract.contractStartDate}</td>
            <td>${contract.contractEndDate}</td>
            <td>${contract.deposit}</td>
            <td>${contract.totalMoney}</td>

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

