<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<jsp:useBean id="userbeans" scope="session" class="model.UserBean" />

<html>
<head>
<meta charset="UTF-8">
<title>ようこそ<jsp:getProperty name="userbeans" property="loginid" />様
</title>
</head>
<body>
	ようこそ<jsp:getProperty name="userbeans" property="loginid" />様
	<h1>商品検索</h1>

	<form action="/ECsite/search" method="post">
		<select name="category">
			<option value="0">すべて</option>
			<c:forEach var="cat" items="${insertCategory}">
				<option value="${cat.categoryid}">${cat.category}</option>
			</c:forEach>
		</select> <input type="text" name="ken"> <input type="submit"
			value="検索">
	</form>
	${errorm}
	<table border="1">
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>在庫</th>
		</tr>
		<c:forEach var="productbean" items="${insertproduct}">
			<tr>
				<td><a href="/ECsite/productdetails?procd=${productbean.procd}">${productbean.proname}
				</a></td>
				<td>${productbean.proprice}</td>
				<td>${productbean.stockno}</td>
			</tr>
		</c:forEach>
	</table>

	<%--


	<c:forEach var="ProductBean" items="${insertCategory}">


		<form action="/ECsite/search" method="post">
			<br> <input type="text" name="searchpro"><br> <input
				type="submit" value="Search">

		</form>

		<table border="1">



			<c:forEach var="ProductBean" items="${insertCategory}">
				<tr>
					<td>${UserBean.id}</td>
					<td>${UserBean.name}</td>
					<td>${UserBean.age}</td>
				</tr>
			</c:forEach>
		</table>
		 --%>
</body>
</html>