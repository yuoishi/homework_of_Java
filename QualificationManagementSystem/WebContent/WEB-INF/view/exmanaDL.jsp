<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.ExMana" %>
<%@ page import="dto.Qualification" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受験データ一覧 | 資格取得状況管理システム</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		ArrayList<ExMana> list = (ArrayList<ExMana>)request.getAttribute("exmana");
		ArrayList<Qualification> qList = (ArrayList<Qualification>)request.getAttribute("qualification");
	%>
	<div id="main">
		<h1>受験データ一覧</h1>

		<div id="sub">
			<!--学年・クラスごとに一覧管理処理-->
			<form action="ExMana" method="get" class="greadclass">
				<label>学年
					<select name="grade">
						<option value="0">-</option>
						<% for(int i = 1; i <= 4; i++){ %>
							<option value=<%= i %>><%= i %></option>
						<% } %>
					</select>
				</label>

				<label>組
					<select name="class">
						<option value="0">-</option>
						<option value="1">1</option>
						<option value="2">2</option>
					</select>
				</label>
				<input type="submit" value="実行">

				<input type="hidden" name="flg" value="0">
				<input type="hidden" name="scope" value="scope">
			</form>

			<form action="ExMana" method="get" class="exmana">
				<label>資格名
					<select name="qname">
						<% for(Qualification q : qList){ %>
							<option value=<%= q.getName() %>><%= q.getName() %></option>
						<% } %>
					</select>
				</label>
				<input type="submit" value="絞り込み">
				<input type="hidden" name="flg" value="0">
				<input type="hidden" name="extraction" value="extraction">
			</form>

			<form action="Student" method="get" class="moving">
				<input type="hidden" name="flg" value="0">
				<input type="submit" value="学生一覧">
			</form>

			<form action="Main" method="get" class="main">
				<input type="hidden" name="flg" value="main">
				<input type="submit" value="メインページ">
			</form>

			<form action="ExMana" method="get" class="csv">
				<input type="submit" value="CSV出力">
				<input type="hidden" name="flg" value="0">
				<input type="hidden" name="csv" value="csv">
			</form>

			<table id="exmana">
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
		</div>
	</div>
</body>
</html>