<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Facility List</h1>
<p>
    <a href="/facility?action=create">Create new facility</a>
</p>
<table class="table" id="tableData">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Area</th>
        <th>Cost</th>
        <th>Max people</th>
        <th>Standard room</th>
        <th>Description other convenience</th>
        <th>Pool area</th>
        <th>Number of floors</th>
        <th>Facility free</th>
        <th>Rent type id</th>
        <th>Facility type id</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${facilityList}" var="facility">
        <tr>
            <td>${facility.facilityId}</td>
            <td>${facility.facilityName}</td>
            <td>${facility.area}</td>
            <td>${facility.cost}</td>
            <td>${facility.maxPeople}</td>
            <td>${facility.standardRoom}</td>
            <td>${facility.descriptionOtherConvenience}</td>
            <td>${facility.poolArea}</td>
            <td>${facility.numberOfFloors}</td>
            <td>${facility.facilityFree}</td>
            <td>
                <c:choose>
                    <c:when test="${facility.getRentTypeId()==1}"><p>Năm</p></c:when>
                    <c:when test="${facility.getRentTypeId()==2}"><p>Tháng</p></c:when>
                    <c:when test="${facility.getRentTypeId()==3}"><p>Ngày</p></c:when>
                    <c:when test="${facility.getRentTypeId()==4}"><p>Giờ</p></c:when>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${facility.getFacilityTypeId()==1}"><p>Villa</p></c:when>
                    <c:when test="${facility.getFacilityTypeId()==2}"><p>House</p></c:when>
                    <c:when test="${facility.getFacilityTypeId()==3}"><p>Room</p></c:when>
                </c:choose>
            </td>
            <td><a href="/facility?action=edit&id=${facility.getFacilityId()}">edit</a></td>
            <td><a href="/facility?action=delete&id=${facility.getFacilityId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
