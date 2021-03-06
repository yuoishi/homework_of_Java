<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生登録 | 資格取得状況管理システム</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="main">
	<h1>学生登録</h1>
	<form action="Main" method="get">
		<label>学籍番号：
			<input type="text" name="no">
		</label><br>

		<label>氏名：
			<input type="text" name="name">
		</label><br>

		<label>学年：
			<select name="grade">
					<% for(int i = 1; i <= 4; i++){ %>
						<option value=<%= i %>><%= i %></option>
					<% } %>
				</select>
			</label><br>

			<label>組：
				<select name="class">
					<option value="1">1</option>
					<option value="2">2</option>
				</select>
			</label><br>

			<input type="hidden" name="flg" value="sR">
			<input type="submit" value="登録">
		</form>
		<form action="Main" method="get">
			<input type="hidden" name="flg" value="cancel">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>