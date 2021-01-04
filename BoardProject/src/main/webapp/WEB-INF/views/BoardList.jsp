<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
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
</head>
<body>
   <table>
      <colgroup>
         <col width="100px">
         <col width="300px">
         <col width="100px">
         <col width="100px">
      </colgroup>

      <tr>
         <td>글번호</td>
         <td>제목</td>
         <td>작성자</td>
         <td>조회수</td>
      </tr>
      <c:forEach var="i" items="${list}">
         <tr>
            <td>${i.bnum}</td>
            <td><a href="boarddetail?bnum=${i.bnum}&page=${paging.page}">${i.btitle}</a></td>
            <td>${i.bwriter}</td>
            <td>${i.bhits}</td>
         </tr>
      </c:forEach>
   </table>
   <!-- 페이징 처리 -->
	<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
	
	<c:if test="${paging.page>1}">
		<a href="boardlist?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
			${i}
			</c:when>
			<c:otherwise>
				<a href="boardlist?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.page>=paging.maxPage}">
		[다음]	
	</c:if>
	
	<c:if test="${paging.page<paging.maxPage}">
		<a href="boardlist?page=${paging.page+1}">[다음]</a>
	</c:if>

   <a href="./">홈으로가기</a>
</body>
</html>