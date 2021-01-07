<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
let idCheck = false;
let pwd = false;
let pwdCheck = false;
function idOverlap(){
	var inputId = document.getElementById("mid").value;
	var result1 = document.getElementById("result");
	

	$.ajax({
		type:"post",
		url:"idoverlap",
		data:{mid:inputId},
		dataType:"text",
		
		success : function(result){
				if (result == 0) {
					result1.style.color = "green";
					result1.innerHTML="사용가능한 아이디입니다.";
					idCheck=true;
				}else{
					idCheck=false;
					result.style.color="red";
					result.innerHTML="사용중인 아이디입니다.";
				}	
		},
		error: function(){
			alert("데이터 통신 실패");
		}
	
	});
	
}
function pwConfirm(){
	   var userPw = document.getElementById("mpwd").value;
	   var confirmPw = document.getElementById("confirmPw");
	   
	   var num = userPw.search(/[0-9]/g);
	   var eng = userPw.search(/[a-z]/ig);
	   var spe = userPw.search(/[`~!@@#$%^&*|₩₩₩'₩';:₩/?]/gi);
	   
	   if(userPw.search(/\s/)!=-1){
	      pwd=false;
	      confirmPw.style.color = "#ff0000";
	      confirmPw.innerHTML = "비밀번호는 공백 없이 입력해주세요!";
	   } else if (userPw.length < 8 || userPw.length > 20){
	      pwd=false;
	      confirmPw.style.color = "#ff0000";
	      confirmPw.innerHTML = "8자리 ~ 20자리 이내로 입력해주세요!";
	   } else if( num < 0 || eng < 0 || spe < 0 ){
	      pwd=false;
	      confirmPw.style.color = "#ff0000";
	      confirmPw.innerHTML = "영문, 숫자, 특수문자를 혼합하여 입력해주세요!";
	   } else {
	      pwd=true;
	      confirmPw.style.color = "#0000ff";
	      confirmPw.innerHTML = "적절한 비밀번호 입니다!";
	   }
	}
	function CheckPw() {
	   var userPw = document.getElementById("mpwd").value;
	   var userPw2 = document.getElementById("checkpwd").value;
	   var result = document.getElementById("resultpwd");
	   if (userPw==userPw2) {
	      if (userPw!="") {
	         pwdCheck=true;
	         result.style.color = "blue";
	         result.innerHTML = "비밀번호가 일치합니다";
	      }else {
	         pwdCheck=false;
	         result.style.color = "red";
	         result.innerHTML = "비밀번호를 입력해주세요.";
	      }
	   }else {
	      pwdCheck=false;
	      result.style.color = "red";
	      result.innerHTML = "비밀번호가 일치하지 않습니다.";
	   }
	}
	function gosubmit() {
	   if (idCheck==true) {
	      if (pwd==true) {
	         if (pwdCheck==true) {
	            formN.submit();
	         }else {
	            alert("비밀번호가 일치하지 않습니다.");
	            checkpwd.focus();
	         }
	      }else {
	         alert("비밀번호 양식을 맞춰주세요.");
	         upwd.focus();
	      }
	   }else {
	      alert("아이디를 확인해주세요.");
	      uid.focus();
	   }
	   
	}

</script>
<body>
<form action="memberJoin" method="post" enctype="multipart/form-data">
아이디 : <input type="text" name="mid"id="mid" onkeyup="idOverlap()">
<span id="result"></span><br/>
비밀번호 : <input type="password" name="mpwd" id="mpwd" onchange="pwConfirm()"><span id="confirmPw"></span><br/>
비밀번호 확인 : <input type="password" id="checkpwd" onchange="CheckPw()"><span id="resultpwd"></span><br/>
이름 : <input type="text" name="mname"><br/>
핸드폰번호 : <input type="text" name="mnumber"><br/>
이메일 : <input type="email" name="memail"><br/>
생일 : <input type="date" name="mbirth"><br/>
주소 : <input type="text" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" name="madd"><br>
<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="madd">
<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="madd">
<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="madd">
<input type="text" id="sample4_extraAddress" placeholder="참고항목" name="madd">
<input type="button" value="회원가입" onclick="gosubmit()">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</form>
</body>
</html>