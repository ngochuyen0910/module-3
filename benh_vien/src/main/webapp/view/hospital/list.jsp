<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<h1>Danh sách bệnh án</h1>

<table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
    <tr>
        <th>STT</th>
        <th>Ma benh an</th>
        <th>Ma benh nhan</th>
        <th>Ten benh nhan</th>
        <th>Ngay nhap vien</th>
        <th>Ngay ra vien</th>
        <th>Ly do nhap vien</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${benhNhanList}" var="benhNhan">
        <tr>
            <td>${benhNhan.stt}</td>
            <c:forEach items="${benhAnList}" var="benhAn">
                <c:if test="${benhAn.maBenhAn==benhNhan.maBenhAn}">
                    <td>${benhAn.tenBenhAn}</td>
                </c:if>
            </c:forEach>
            <td>${benhNhan.maBenhNhan}</td>
            <td>${benhNhan.tenBenhNhan}</td>
            <td>${benhNhan.ngayNhapVien}</td>
            <td>${benhNhan.ngayRaVien}</td>
            <td>${benhNhan.lyDoNhapVien}</td>
            <td><a href="/hospital?action=edit&id=${benhNhan.getStt()}">Edit</a></td>
            <td>
                <button type="button" class="btn btn-primary"
                        onclick="infoDelete('${benhNhan.getStt()}','${benhNhan.getTenBenhNhan()}')"
                        data-bs-toggle="modal" data-bs-target="#exampleModal"> Delete
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/hospital" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="id" id="idDelete">
                    <input type="text" hidden name="action" value="delete">
                    <span>Bạn có muốn xóa dự án : </span>
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
