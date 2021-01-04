<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="board-update" method="post">
      <table>
         <tr>
             <td>글번호</td>
            <td>${bnum} <input type="hidden" value="${bnum}" name="bnum"></td>
         </tr>
         
         <tr>
            <td>제목</td>
            <td>${list.btitle}</td>
         </tr>
         
         <tr>
            <td colspan="2" style="padding: 0"><textarea rows="15" cols="40" style="resize: none;" name="bcontents"></textarea></td>
         </tr>
         <tr>
            <td colspan="2">
               <button style="width: 100px; height: 40px">글 수정</button>
            </td>
         </tr>
      </table>
   </form>
</body>
</html>