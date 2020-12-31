<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
/* 아이디 중복처리 과정
	아이디 입력창에 있는 값을 스크립트 함수에 가져옴
	입력값을 ajax를 이용해 서버(컨트롤러로 보내고 결과값을 가져옴)
	결과값에 따라 사용여부 메세지를 입력칸 옆에 출력*/
function idoOverlap(){
	var inputId = $("#mid").val();
	var result1 = document.getElementById("result");
	/* json방식으로 보냄 */
	$.ajax({
		type:"post",
		url:"idoverlap",
		data:{mid:inputId},
		dataType: "text",	//리턴데이터형식
		
		success : function(result){
			if(result=="ok"){
				result1.style.color="green";
				result1.innerHTML="사용가능한 아이디입니다.";
			}else{
				result1.style.color="red";
				result1.innerHTML="사용중인 아이디입니다."
			}
		},
		error : function(){
			alert("데이터 통신 실패");
		}
	});
}

</script>
<body>
<h1>
	회원가입 페이지
</h1>
<form action="memberJoin" method="post">
아이디 : <input type="text" name="mid"id="mid" onkeyup="idoOverlap()">
<span id="result"></span><br/>
비밀번호 : <input type="password" name="mpwd"><br/>
이름 : <input type="text" name="mname"><br/>
핸드폰번호 : <input type="text" name="mphone"><br/>
이메일 : <input type="email" name="memail"><br/>
생일 : <input type="date" name="mbirth"><br/>
<input type="submit" value="제출">
</form>
<a href="memberlogin">로그인 페이지로</a>
</body>
</html>