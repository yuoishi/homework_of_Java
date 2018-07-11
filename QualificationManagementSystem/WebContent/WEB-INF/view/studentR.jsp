<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生登録 | 資格取得状況管理システム</title>
</head>
<body>
	<form action="Main" method="get">
		<label>学籍番号：
			<input type="text">
		</label><br>

		<label>氏名：
			<input type="text">
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
</body>
</html>