<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Qualification" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受験データ登録 | 資格取得状況管理システム</title>
</head>
<body>
	<%
		ArrayList<Qualification> list = (ArrayList<Qualification>)request.getAttribute("qualification");
	%>

	<form action="Main" method="get">
		<label>受験日：
			<select name="year">
				<% for(int i = 2018; i >= 1986; i--){ %>
					<option value=<%= i %>><%= i %></option>
				<% } %>
			</select>
			-
			<select name="month">
				<% for(int i = 1; i <= 12; i++){ %>
					<option value=<%= i %>><%= i %></option>
				<% } %>
			</select>

			-
			<select name="day">
				<% for(int i = 1; i <= 31; i++){ %>
					<option value=<%= i %>><%= i %></option>
				<% } %>
			</select>
		</label><br>

		<label>学籍番号：
			<input type="text" name="no">
		</label><br>

		<label>資格名：
			<select name="qname">
				<% for(Qualification q : list){ %>
					<option value=<%= q.getName() %>><%= q.getName() %></option>
				<% } %>
			</select>
		</label><br>

		<label>合否：
			<select name="sorf">
				<option value="合格">合格</option>
				<option value="不合格">不合格</option>
			</select>
		</label><br>

		<input type="hidden" name="flg" value="emR">
		<input type="submit" value="登録">
	</form>
</body>
</html>