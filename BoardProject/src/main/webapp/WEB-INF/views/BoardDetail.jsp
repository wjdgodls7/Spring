<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style>
table, tr, td {
	text-align: center;
	margin: auto;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}

body {
	text-align: center;
}
</style>
<script>

$(document).ready(function(){
	$("#commentwritebtn").click(function(){
		var cwriter = $("#cwriter").val();
		var ccontents = $("#ccontents").val();
		var cbnumber = '${list.bnum}';
		$.ajax({
			type : "post",
			url : "comment/commentwrites",
			data : {
				"cwriter":cwriter,
				"ccontents":ccontents,
				"cbnumber":cbnumber
				},
			dataType:"json",
			success:function(result){
				 var output = "<table boarder = '1'>";
	               output += "<tr><th>작성자</th>";
	               output += "<th>내용</th></tr>";
	               for(var i in result) {
	                  output += "<tr>";
	                  output += "<td>" + result[i].cwriter+"</td>";
	                  output += "<td>" + result[i].ccontents+"</td>";
	                  output += "</tr>";
	               }
	               output += "</table>";
	               $("#commentArea").html(output);
	               $("#cwriter").val("");
	               $("#ccontents").val("");
			},
			error: function(){
				alert("데이터 통신 실패");
			}
			
		});
	});
});
</script>

<body>
	<form action="regBoard" method="post">
		<table>
			<tr>
				<td>글번호</td>
				<td>${list.bnum}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${list.btitle}</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><img src="resources/uploadFile/${list.bfilename}"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${list.bwriter}</td>
			</tr>
			<tr>
				<td>글조회수</td>
				<td>${list.bhits}</td>
			</tr>
			<tr>
				<td>작성날짜</td>
				<td>${list.bdate}</td>
			</tr>
			<tr>
				<td colspan="2" style="padding: 0"><textarea rows="15"
						cols="40" style="resize: none;" name="bcontents">${list.bcontents}</textarea></td>
			</tr>
		</table>
	</form>
	<button onclick="boardlist()">목록</button>
	<button onclick="boardupdate()">수정</button>
	<button onclick="boarddelete()">삭제</button>
	<div id="commentwrite">
		작성자 : <input type="text" id="cwriter"> 내용 : <input type="text"
			id="ccontents">
		<button id="commentwritebtn">댓글 작성</button>
	</div>
	<div id="commentArea">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>내용</td>
			</tr>
			<c:forEach var="comment" items="${result}">
				<tr>
					<td>${comment.cwriter}</td>
					<td>${comment.ccontents}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="./">홈으로가기</a>
</body>
<script>
function boardlist(){
	location.href="boardlist?page="+${page};
}
function boardupdate(){
	location.href="boardupdate?bnum="+${list.bnum};
}
function boarddelete(){
	location.href="boarddelete?bnum="+${list.bnum};
}
</script>
</html>




