<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<p>
    <a href="/customer">Back to employee list</a>
</p>
<div class="container">
    <form method="post" action="/customer?action=create">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Id</label>
            <input name="customerId" type="number" class="form-control" id="exampleInputEmail1">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input name="customerName" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Date Of Birth</label>
            <input name="customerBirthday" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Gender</label>
            <input name="customerGender" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Id card</label>
            <input name="customerIdCard" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Phone number</label>
            <input name="customerPhone" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email</label>
            <input name="customerMail" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Address</label>
            <input name="customerAddress" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Customer type id</label>
            <input name="customerTypeId" type="number" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

