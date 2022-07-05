<%--
  Created by IntelliJ IDEA.
  User: Ngọc Mai
  Date: 6/29/2022
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Student List</h1>
<form action="/student">
    <input type="text" name="nameSearch">
    <input type="submit" name="action" value="search">
</form>
<table class="table" id="tableData">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Class Name</th>
        <th>Gender</th>
        <th>Score</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <%--       for (Datatype element : List ) --%>
    <%--        items ~ List , element ~ var=student --%>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td> ${student.id}</td>
            <td> ${student.name} </td>
            <td> ${student.className} </td>

            <c:if test="${student.gender == 0}">
                <td>Male</td>
            </c:if>
            <c:if test="${student.gender == 1}">
                <td>Female</td>
            </c:if>

                <%--             score > 5 -> Kha   --%>
                <%--             score > 7 -> Goi   --%>
                <%--             score > 9 -> Xuat sac   --%>
            <c:choose>
                <c:when test="${student.score > 5}">
                    <td>Kha</td>
                </c:when>
                <c:when test="${student.score > 7}">
                    <td>Gioi</td>
                </c:when>
                <c:when test="${student.score > 9}">
                    <td>Xuat Sac</td>
                </c:when>
                <c:otherwise>
                    <td>Tach</td>
                </c:otherwise>
            </c:choose>
            <td><a href="/student?action=edit&id=${student.getId()}">edit</a></td>
            <td><a href="/student?action=delete&id=${student.getId()}">delete</a></td>
        </tr>
    </c:forEach>

</table>
<button id="btnClick">Click me!</button>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js">
</script>
<script src="jquery-style.js"></script>
</html>
