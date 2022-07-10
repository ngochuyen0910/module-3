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
    <form method="post" action="/hospital?action=edit">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">STT</label>
            <input name="stt" value="${benhNhan.getStt()}" readonly type="number" class="form-control"
                   id="exampleInputEmail1">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Ma benh an</label>
            <select name="maBenhAn" class="form-control">
                <c:forEach items="${benhAnList}" var="benhAn">
                    <c:if test="${benhAn.maBenhAn == benhNhan.maBenhAn}">
                        <option value="${benhAn.maBenhAn}" selected>${benhAn.tenBenhAn}</option>
                    </c:if>
                    <c:if test="${benhAn.maBenhAn != benhNhan.maBenhAn}">
                        <option value="${benhAn.tenBenhAn}">${benhAn.tenBenhAn}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Ma benh nhan</label>
            <input name="maBenhNhan" value="${benhNhan.getMaBenhNhan()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">ten benh nhan</label>
            <input name="tenBenhNhan" value="${benhNhan.getTenBenhNhan()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Ngay nhap vien</label>
            <input name="ngayNhapVien" value="${benhNhan.getNgayNhapVien()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Ngay ra vien</label>
            <input name="ngayRaVien" value="${benhNhan.getNgayNhapVien()}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Li do nhap vien</label>
            <input name="lyDoNhapVien" value="${benhNhan.getLyDoNhapVien()}" type="text" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
