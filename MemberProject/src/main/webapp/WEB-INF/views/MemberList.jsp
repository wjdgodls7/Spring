<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
function memberviewAjax(mid){
	$.ajax({
		type:"post",
		url:"memberviewajax",
		data:{"mid":mid},
		dataType:"json",
		success: function(result){
			var output = "<table border='1'>";
			output += "<tr><th>ID</th> <th>PASSWORD</th> <th>NAME</th>";
			output += "<th>PHONE</th> <th>EMAIL</th> <th>BIRTH</th></tr>";
			output += "<tr>";
			output += "<td>"+result.mid+"</td>";
			output += "<td>"+result.mpassword+"</td>";
			output += "<td>"+result.mname+"</td>";
			output += "<td>"+result.mphone+"</td>";
			output += "<td>"+result.memail+"</td>";
			output += "<td>"+result.mbirth+"</td>";
			output += "</tr>";
			output += "</table>";
			$("#memberview").html(output);
		},
		error: function(){
			alert("데이터 통신 오류");
		}
	})
}
</script>
<body>
<c:forEach items="${ list}" var="list">
<h1><a href="memberdetail?detail=${list.getMid()}">${list.getMid()} </a> ${list.getMname()} ${list.getMphone()}</h1>
<a href="memberDel?delid=${list.getMid()}">회원 삭제</a>
<button onclick="memberviewAjax('${list.getMid()}')">ajax조회</button>
</c:forEach>
<div id="memberview">
</div>
</body>
</html>