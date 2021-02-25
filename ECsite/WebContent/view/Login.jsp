<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>木内販売店ログイン</title>
</head>
<body>
	<h1>ログイン</h1>
	<form action="/ECsite/login" method="post">
		<br> 名前<input type="text" name="userid"><br> パスワード<input
			type="password" name="password"> <br> <input
			type="submit" value="Login"> ${errorm}

	</form>

</body>
</html>