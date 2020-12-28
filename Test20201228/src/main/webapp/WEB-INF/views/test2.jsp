<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	첫번째 :
	<p>${par1}</p>
	두번째 :
	<p>${par2}</p>
	<a href="./">홈으로 가기</a>
	<form action="insertDB">
		<input type="text" name="data1">
		<input type="submit">
	</form>
</body>
</html>