<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-secondary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="logo furama.png" alt="" width="100" height="70" class="d-inline-block align-text-top">
        </a>
        <a class="nav-link active" aria-current="page" href="#"><span class="navbar-text ">Trương Ngọc Huyền</span></a>
    </div>
</nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Employee
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/employee">Employee list</a></li>
                        <li><a class="dropdown-item" href="/employee?action=create">Add new employee</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Customer
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/customer">Customer list</a></li>
                        <li><a class="dropdown-item" href="/customer?action=create">Add New Customer</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Service
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/facility">Facility list</a></li>
                        <li><a class="dropdown-item" href="/facility?action=create">Add New Facility</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Contract
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/contract">Facility list</a></li>
                        <li><a class="dropdown-item" href="/contract?action=create">Add New Contract</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <p>Item One</p>
                        <p>Item Two</p>
                        <p>Item Three</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-9">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <img src="Sun_Peninsula_Residence_Villa_2__DNOE.jpg" height="1000" width="1700"
                             class="img-fluid" alt="...">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer bg-secondary">
    <p>
    <center>Footer...</center>
    </p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
