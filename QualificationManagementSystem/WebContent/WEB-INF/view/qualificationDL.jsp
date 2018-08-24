<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Qualification" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資格一覧 | 資格取得状況管理システム</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		ArrayList<Qualification> list = (ArrayList<Qualification>)request.getAttribute("qualification");
	%>
	<h1>資格一覧</h1>

	<form action="Main" method="get">
		<input type="hidden" name="flg" value="main">
		<input type="submit" value="メインページ">
	</form>

	<table>
		<tr>
			<th>資格ID</th><th>資格名</th><th>資格グレード</th>
		</tr>

		<% for(Qualification q : list){ %>
			<tr>
				<td><%= q.getId() %></td>
				<td><%= q.getName() %></td>
				<td><%= q.getGrade() %></td>
			</tr>
		<% } %>

	</table>
</body>
</html>