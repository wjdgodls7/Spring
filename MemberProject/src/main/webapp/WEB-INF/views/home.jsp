<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	회원가입 페이지
</h1>
<form action="memberJoin" method="post">
<input type="text" name="mid" value="아이디">
<input type="password" name="mpwd" value="비밀번호">
<input type="text" name="mname" value="이름">
<input type="text" name="mphone" value="전화번호">
<input type="email" name="memail" value="이메일">
<input type="date" name="mbirth" value="생년월일">
<input type="submit" value="제출">
</form>
<a href="memberlogin">로그인 페이지로</a>
</body>
</html>
