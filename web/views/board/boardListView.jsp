<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board, java.util.ArrayList, java.sql.Date" %>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript">
function showWriteForm(){
	location.href = "/first/views/board/boardWriteForm.jsp?page=<%= currentPage %>";
}
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr>
<h1 align="center">총 목록 갯수 : <%= listCount %></h1>
<%-- 로그인한 사용자만 글쓰기 기능 사용할 수 있게 함 --%>
<% if(loginMember != null){ %>
<div style="align:center; text-align:center;">
	<button onclick="showWriteForm();">글쓰기</button>
</div>
<% } %>
<br>
<table align="center" border="1" width="700" cellspacing="0">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th>
<th>첨부파일</th></tr>
<% for(Board board : list){ %>
<tr>
	<td align="center"><%= board.getBoardNum() %></td>
	<td>
	<%-- 댓글일때는 제목을 들여쓰기함 --%>
	<% if(board.getBoardReplyLev() == 2){  //원글의 댓글일 때 %>
	&nbsp; &nbsp; ▶ 
	<% }else if(board.getBoardReplyLev() == 3){ //댓글의 댓글일 때 %>
	&nbsp; &nbsp; &nbsp; &nbsp; ▶▶
	<% } %>
	<%-- 로그인한 사용자만 게시글 상세보기할 수 있게 처리함 --%>
	<% if(loginMember != null){ %>
	<a href="/first/bdetail?bnum=<%= board.getBoardNum() %>&page=<%= currentPage %>"><%= board.getBoardTitle() %></a>
	<% }else{ %>
	<%= board.getBoardTitle() %>
	<% } %>
	</td>
	<td align="center"><%= board.getBoardWriter() %></td>
	<td align="center"><%= board.getBoardDate() %></td>
	<td align="center"><%= board.getBoardReadCount() %></td>
	<td align="center">
		<% if(board.getBoardOriginalFileName() != null){ %>
		◎
		<% }else{ %>
		&nbsp;
		<% } %>
	</td>
</tr>
<% } //for each  %>
</table>
<br>
<%-- 페이징 처리 
	[맨처음][이전] 숫자...........  [다음][맨끝]
--%>
<div style="text-align: center;">
<%-- 현재 페이지가 1이 아니면 링크설정, 현재 1페이지이면 링크없음 --%>
<% if(currentPage <= 1){ %>
[맨처음]
<% }else{ %>
<a href="/first/blist?page=1">[맨처음]</a>
<% } %> &nbsp;
<%-- 이전 그룹이 있으면 링크설정, 이전 그룹 없으면 링크없음 --%>
<% if((currentPage - 10) < startPage && (currentPage - 10) >= 1){ %>
<a href="/first/blist?page=<%= startPage - 10 %>">[이전]</a>
<% }else{ %>
[이전]
<% } %> &nbsp;
<%-- 가운데 표시할 페이지 그룹 숫자 링크 설정 --%>
<% for(int p = startPage; p <= endPage; p++){ 
		if(p == currentPage){
%>
<font size="4" color="red">[<%= p %>]</font>
<% }else{ %>
<a href="/first/blist?page=<%= p %>"><%= p %></a>
<%  } //else 
	} //for %> &nbsp;
<%-- 다음 그룹이 있으면 링크설정, 다음 그룹 없으면 링크없음 --%>
<% if((currentPage + 10) > endPage && (currentPage + 10) < maxPage){ %>
<a href="/first/blist?page=<%= endPage + 10 %>">[다음]</a>
<% }else{ %>
[다음]
<% } %> &nbsp;
<%-- 현재 페이지가 끝이 아니면 링크설정, 끝페이지이면 링크없음 --%>
<% if(currentPage >= maxPage){ %>
[맨끝]
<% }else{ %>
<a href="/first/blist?page=<%= maxPage %>">[맨끝]</a>
<% } %>
</div>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>









