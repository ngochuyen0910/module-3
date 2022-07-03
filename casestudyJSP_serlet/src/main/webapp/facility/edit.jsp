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
    <form method="post" action="/facility?action=edit">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Facility Id</label>
            <input name="facilityId" value="${facility.getFacilityId()}" type="number" class="form-control" id="exampleInputEmail1">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Facility Name</label>
            <input name="facilityName" value="${facility.getFacilityName()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Area</label>
            <input name="area"value="${facility.getArea()}"  type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Cost</label>
            <input name="cost" value="${facility.getCost()}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Max People</label>
            <input name="maxPeople" value="${facility.getMaxPeople()}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Standard Room</label>
            <input name="standardRoom"value="${facility.getStandardRoom()}"  type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Description Other Convenience</label>
            <input name="descriptionOtherConvenience"value="${facility.getDescriptionOtherConvenience()}"  type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Pool Area</label>
            <input name="poolArea"value="${facility.getPoolArea()}"  type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Number Of Floors</label>
            <input name="numberOfFloors"value="${facility.getNumberOfFloors()}"  type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Facility Free</label>
            <input name="facilityFree"value="${facility.getFacilityFree()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Rent Type Id</label>
            <input name="rentTypeId"value="${facility.getRentTypeId()}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Facility Type Id</label>
            <input name="facilityTypeId" value="${facility.getFacilityTypeId()}"type="number" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
