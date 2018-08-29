<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生一覧 | 資格取得状況管理システム</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("student");
	%>
	<div id="main">
		<h1>学生一覧</h1>

		<div id="sub">
			<form action="ExMana" method="get" class="moving">
				<input type="hidden" name="flg" value="0">
				<input type="submit" value="受験データ一覧">
			</form>

			<form action="Main" method="get" class="main">
				<input type="hidden" name="flg" value="main">
				<input type="submit" value="メインページ">
			</form>

			<table id="student">
				<tr>
					<th>学籍番号</th><th>学年</th><th>組</th><th>学生氏名</th>
				</tr>
				<% for(Student s : list){ %>
					<tr>
						<td><%= s.getNo() %></td>
						<td><%= s.getGrade() %></td>
						<td><%= s.getClas() %></td>
						<td><%= s.getName() %></td>
					</tr>
				<% } %>
			</table>
		</div>
	</div>
</body>
</html>