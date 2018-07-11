<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録 | 資格取得状況管理システム</title>
</head>
<body>
	<form action="Main" method="get">
		<label>ID：
			<input type="text">
		</label><br>

		<label>PW：
			<input type="password">
		</label><br>

		<label>先生の名前：
			<input type="text">
		</label><br>

		<input type="hidden" name="flg" value="aR">
		<input type="submit" value="登録">
	</form>
</body>
</html>