<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資格登録 | 資格取得状況管理システム</title>
</head>
<body>
	<form action="Main" method="get">
		<label>資格ID：
			<input type="number">
		</label><br>

		<label>資格名：
			<input type="text">
		</label><br>

		<label>資格グレード：
			<select name="grade">
				<% for(int i = 1; i <= 5; i++){ %>
					<option value=<%= i %>><%= i %></option>
				<% } %>
			</select>
		</label><br>

		<input type="hidden" name="flg" value="qR">
		<input type="submit" value="登録">
	</form>
</body>
</html>