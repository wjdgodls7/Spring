<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function idOverlap(){
	var inputId = ${#mid}.val();
	var result = document.getElementByid("result");
	$.ajax({
		type:"post",
		url:"idoverlap",
		data:{mid:inputId},
		dataType:"text",
		
		success:function(result){
				if (result == 0) {
					result.syle.color ="green";
					result.innerHTML="사용가능한 아이디입니다.";
				}else{
					result.style.color="red";
					result.innerHTML="사용중인 아이디입니다.";
				}	
		},
		error: function(){
			alert("데이터 통신 실패");
		}
	
	});
	
}
</script>
<body>
<form action="memberJoin" method="post" enctype="multipart/form-data">
아이디 : <input type="text" name="mid"id="mid" onkeyup="idOverlap()">
<span id="result"></span><br/>
비밀번호 : <input type="password" name="mpwd"><br/>
이름 : <input type="text" name="mname"><br/>
핸드폰번호 : <input type="text" name="mphone"><br/>
이메일 : <input type="email" name="memail"><br/>
생일 : <input type="date" name="mbirth"><br/>
프로필사진 : <input type="file" name="mfile"><br/>
<input type="submit" value="제출">
</form>
</body>
</html>