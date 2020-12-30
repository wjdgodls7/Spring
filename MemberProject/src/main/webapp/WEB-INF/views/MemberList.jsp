<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${ list}" var="list">
<h1><a href="memberdetail?detail=${list.getMid()}">${list.getMid()} </a> ${list.getMname()} ${list.getMphone()}</h1>
<a href="memberDel?delid=${list.getMid()}">회원 삭제</a>
</c:forEach>

</body>
</html>