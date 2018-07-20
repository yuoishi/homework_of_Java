<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資格取得状況管理システム</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="main">
		<h1 class="top">資格取得状況管理システム</h1>
		<form action="Main" method="post">
			<label>ID:<input type="text" name="id"></label><br>
			<label>PW:<input type="password" name="pw"></label><br>
			<input type="submit" value="ログイン" class="login">
		</form>
	</div>
</body>
</html>