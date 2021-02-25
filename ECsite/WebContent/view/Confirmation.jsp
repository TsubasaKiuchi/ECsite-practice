<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
</head>
<body>
<h1>購入してよろしいでしょうか</h1>
<table border="1">
<tr>
<th>商品名</th><th>単価</th><th>数量</th>
</tr>

<c:forEach var="cartinfotable" items="${cartmodel.cartlist}">
<tr>
<td>${cartinfotable.proname}</td>
<td>${cartinfotable.proprice}</td>
<td>${cartinfotable.quanity}</td>
<tr>
</c:forEach>
<tr>
<td>消費税</td>
<td>${cartmodel.tax}</td>
</tr>
<tr>
<td>合計金額</td>
 <td>${cartmodel.totalprice + cartmodel.tax}</td>
</tr>
</table>

<form action="/ECsite/back" method="post">
<br>
<input type="submit" value="買い物を続ける">
</form>
<form action="/ECsite/complete" method="post">
<br>
<input type="submit" value="購入">
</form>


</body>
</html>