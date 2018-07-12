<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了 | 資格取得状況管理システム</title>
</head>
<body>
	<%
		String flg = (String)request.getAttribute("flg");
		switch(flg){
		case "emR": flg = "受験データ"; break;
		case "sR": flg = "学生データ"; break;
		case "qR": flg = "資格データ"; break;
		case "aR": flg = "アカウント"; break;
		}
	%>
	<p><%= flg %>の登録が完了しました。</p>
	<form action="Main" method="get">
		<input type="submit" value="メインページへ">
	</form>
</body>
</html>