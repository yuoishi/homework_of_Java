<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.ExMana" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受験データ一覧 | 資格取得状況管理システム</title>
</head>
<body>
	<%
		ArrayList<ExMana> list = (ArrayList<ExMana>)request.getAttribute("exmana");
	%>
	<table>
		<tr>
			<th>受験日</th><th>学籍番号</th><th>学生氏名</th><th>資格名</th><th>合否</th>
		</tr>

		<% for(ExMana em : list){ %>
			<tr>
				<td><%= em.getDate() %></td>
				<td><%= em.getSno() %></td>
				<td><%= em.getSname() %></td>
				<td><%= em.getQname() %></td>
				<td><%= em.getSorf() %></td>
			</tr>
		<% } %>

	</table>
</body>
</html>