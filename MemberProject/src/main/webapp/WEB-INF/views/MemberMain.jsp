<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function logout(){
	location.href="memberlogout";
	
}
</script>
<body>
	<h1>아이디 : ${mid} </h1>
	<h2>session : ${loginid}</h2>
	<c:if test="${loginid eq 'ADMIN'}">
	<a href="memberList?id=${loginid}">회원 목록</a>
	</c:if>
	<a href="memberUpdate?ids=${loginid}">정보 수정</a>
	<button onclick="logout()">로그 아웃</button>
</body>
</html>