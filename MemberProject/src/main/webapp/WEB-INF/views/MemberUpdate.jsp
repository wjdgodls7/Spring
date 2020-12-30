<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberUpdateProcess" method="post">
	<span>${detail.getMid()}</span><br/>
	<input type="hidden" name="mid" value="${detail.getMid()}">
	${detail.getMpwd()}	<input type="password" name="mpwd"><br/> 
	${detail.getMname()} <input type="text" name="mname"><br/>
	${detail.getMphone()} <input type="text" name="mphone"><br/>
	${detail.getMemail()} <input type="email" name="memail"><br/>
	${detail.getMbirth()} <input type="date" name="mbirth"><br/>
	<input type="submit" value="제출">
	</form>
</body>
</html>