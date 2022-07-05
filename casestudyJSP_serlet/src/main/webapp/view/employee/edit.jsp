<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form method="post" action="/employee?action=edit">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Id</label>
            <input name="employeeId" value="${employee.getEmployeeId()}" readonly type="number" class="form-control"
                   id="exampleInputEmail1">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input name="employeeName" value="${employee.getEmployeeName()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Date Of Birth</label>
            <input name="employeeBirthday" value="${employee.getEmployeeBirthday()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Id card</label>
            <input name="employeeIdCard" value="${employee.getEmployeeIdCard()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Salary</label>
            <input name="employeeSalary" value="${employee.getEmployeeSalary()}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Phone number</label>
            <input name="employeePhone" value="${employee.getEmployeePhone()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email</label>
            <input name="employeeEmail" value="${employee.getEmployeeEmail()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Address</label>
            <input name="employeeAddress" value="${employee.getEmployeeAddress()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Position id</label>
            <input name="positionId" value="${employee.getPositionId()}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Education DegreeId</label>
            <input name="educationDegreeId" value="${employee.getEducationDegreeId()}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Division Id</label>
            <input name="divisionId" value="${employee.getDivisionId()}" type="number" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
