<%--
  Created by IntelliJ IDEA.
  User: Ngọc Mai
  Date: 6/27/2022
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div style="margin-left: 440px;border: 1px solid;width: 600px">
    <h2 style="text-align: center">Calculator Discount Product</h2>
    <form method="post" action="/calculator">
        <label style="margin: 30px">Product Description: </label>
        <input tyle="text" name="description" value="" style="margin-left: 32px;margin-top: 20px"/><br/>
        <label style="margin: 30px">Product Price(usd): </label>
        <input tyle="text" name="price" value="" style="margin-left: 27px;margin-top: 20px"/><br/>
        <label style="margin: 30px">Discount Percent(%): </label>
        <input tyle="text" name="discount_percent" value="" style="margin-left: 23px;margin-top: 20px"/><br/>
        <input type="submit" id="submit" value="Calculate Discount" style="margin-left: 250px;margin-top: 20px"/><br/>
    </form>
</div>
</body>
</html>
