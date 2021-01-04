<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
            <td colspan="2" style="padding: 0"><textarea rows="15" cols="40" style="resize: none;" name="bcontents">${list.bcontents}</textarea></td>
         </tr>
      </table>
   </form>
   <button onclick="boardlist()">목록</button>
   <button onclick="boardupdate()">수정</button>
   <button onclick="boarddelete()">삭제</button>
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




