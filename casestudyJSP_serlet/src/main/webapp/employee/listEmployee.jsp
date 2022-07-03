<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Employee List</h1>
<p>
    <a href="/employee?action=create">Create new employee</a>
</p>
<table class="table" id="tableData">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Id card</th>
        <th>Salary</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Address</th>
        <th>Position id</th>
        <th>Education DegreeId</th>
        <th>Division id</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.employeeId}</td>
            <td>${employee.employeeName}</td>
            <td>${employee.employeeBirthday}</td>
            <td>${employee.employeeIdCard}</td>
            <td>${employee.employeeSalary}</td>
            <td>${employee.employeePhone}</td>
            <td>${employee.employeeEmail}</td>
            <td>${employee.employeeAddress}</td>
            <td>
                <c:choose>
                    <c:when test="${employee.getPositionId()==1}"><p>Lễ tân</p></c:when>
                    <c:when test="${employee.getPositionId()==2}"><p>Phục vụ</p></c:when>
                    <c:when test="${employee.getPositionId()==3}"><p>Chuyên viên</p></c:when>
                    <c:when test="${employee.getPositionId()==4}"><p>Giám sát</p></c:when>
                    <c:when test="${employee.getPositionId()==5}"><p>Quản lý</p></c:when>
                    <c:when test="${employee.getPositionId()==6}"><p>Giám đốc</p></c:when>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${employee.getEducationDegreeId()==1}"><p>Trung cấp</p></c:when>
                    <c:when test="${employee.getEducationDegreeId()==2}"><p>Cao đẳng</p></c:when>
                    <c:when test="${employee.getEducationDegreeId()==3}"><p>Đại học</p></c:when>
                    <c:when test="${employee.getEducationDegreeId()==4}"><p>Sau đại học</p></c:when>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${employee.getDivisionId()==1}"><p>Sale – Marketing</p></c:when>
                    <c:when test="${employee.getDivisionId()==2}"><p>Hành chính</p></c:when>
                    <c:when test="${employee.getDivisionId()==3}"><p>Phục vụ</p></c:when>
                    <c:when test="${employee.getDivisionId()==4}"><p>Quản lý</p></c:when>
                </c:choose>
            </td>
            <td><a href="/employee?action=edit&id=${employee.getEmployeeId()}">edit</a></td>
            <td><a href="/employee?action=delete&id=${employee.getEmployeeId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
