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
			<input type="text" name="id">
		</label><br>

		<label>PW：
			<input type="password" name="pw">
		</label><br>

		<label>先生の名前：
			<input type="text" name="tname">
		</label><br>

		<input type="hidden" name="flg" value="aR">
		<input type="submit" value="登録">
	</form>
	<form action="Main" method="get">
		<input type="hidden" name="flg" value="cancel">
		<input type="submit" value="戻る">
	</form>
</body>
</html>