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
        <th>Facility type</th>
        <th>Name</th>
        <th>Area</th>
        <th>Cost</th>
        <th>Max people</th>
        <th>Standard room</th>
        <th>Description other convenience</th>
        <th>Pool area</th>
        <th>Number of floors</th>
        <th>Facility free</th>
        <th>Rent type</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${facilityList}" var="facility">
        <tr>
            <td>${facility.facilityId}</td>
            <c:forEach items="${facilityTypeList}" var="facilityType">
                <c:if test="${facilityType.facilityTypeId==facility.facilityTypeId}">
                    <td>${facilityType.facilityTypeName}</td>
                </c:if>
            </c:forEach>
            <td>${facility.facilityName}</td>
            <td>${facility.area}</td>
            <td>${facility.cost}</td>
            <td>${facility.maxPeople}</td>
            <td>${facility.standardRoom}</td>
            <td>${facility.descriptionOtherConvenience}</td>
            <td>${facility.poolArea}</td>
            <td>${facility.numberOfFloors}</td>
            <td>${facility.facilityFree}</td>
            <c:forEach items="${rentTypeList}" var="rentType">
                <c:if test="${rentType.rentTypeId==facility.rentTypeId}">
                    <td>${rentType.rentTypeName}</td>
                </c:if>
            </c:forEach>
            <td><a href="/facility?action=edit&id=${facility.getFacilityId()}">edit</a></td>
            <td>
                <button type="button" class="btn btn-primary"
                        onclick="infoDelete('${facility.getFacilityId()}','${facility.getFacilityName()}')"
                        data-bs-toggle="modal" data-bs-target="#exampleModal"> Delete
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/facility" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="id" id="idDelete">
                    <input type="text" hidden name="action" value="delete">
                    <span>Bạn có muốn xóa dịch vụ : </span>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
