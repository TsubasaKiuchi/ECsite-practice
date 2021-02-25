<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${insertproductdetail.proname}</title>
</head>
<body>
	<h1>商品紹介</h1>
	<img src=${insertproductdetail.proimg}>
	<table border="1">
		<tr>
			<th>商品名</th>
			<td>${insertproductdetail.proname}</td>
		</tr>
		<tr>
			<th>カテゴリ</th>
			<td>${insertproductcategoryname.category}</td>
		</tr>
		<tr>
			<th>価格</th>
			<td>${insertproductdetail.proprice}</td>
		</tr>
		<tr>
			<th>在庫数</th>
			<td>${insertproductdetail.stockno}</td>
		</tr>
		<tr>
			<th>商品説明</th>
			<td>${insertproductdetail.promsg}</td>
		</tr>

	</table>
	<form action="/ECsite/cart" method="post">
		<input type="number" name="addcart" min="1"
			max="${insertproductdetail.stockno}"> <input type="hidden"
			name="cartproname" value="${insertproductdetail.proname}"> <input
			type="hidden" name="cartproprice"
			value="${insertproductdetail.proprice}"> <input type="submit"
			value="カートに入れる">
	</form>
	<form action="/ECsite/back" method="post">
		<input type="submit" value="商品検索に戻る">
	</form>

</body>
</html>