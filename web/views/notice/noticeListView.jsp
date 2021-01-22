<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%-- page 지시자 태그에서 import 속성만 분리해서 따로 지정할 수 있다. --%>    
<%@ page import="java.util.ArrayList, notice.model.vo.Notice" %>    
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="/first/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	showDiv();
	
	$("input[name=item]").on("change", function(){
		showDiv();
	});
}); //jquery document ready

function showDiv(){
	if($("input[name=item]").eq(0).is(":checked")){
		$("#titleDiv").css("display", "block");
		$("#writerDiv").css("display", "none");
		$("#dateDiv").css("display", "none");
	}
	
	if($("input[name=item]").eq(1).is(":checked")){
		$("#titleDiv").css("display", "none");
		$("#writerDiv").css("display", "block");
		$("#dateDiv").css("display", "none");
	}
	
	if($("input[name=item]").eq(2).is(":checked")){
		$("#titleDiv").css("display", "none");
		$("#writerDiv").css("display", "none");
		$("#dateDiv").css("display", "block");
	}
}
</script>
<body>
<%@ include file="../common/header.jsp" %>
<hr>
<h1 align="center">공지사항 목록 보기</h1>
<br>
<%-- 공지사항 검색 --%>
<center>
<div>
	<h2>검색할 항목을 선택하시오.</h2>
	<input type="radio" name="item" value="title" checked> 제목 &nbsp; &nbsp; &nbsp;
	<input type="radio" name="item" value="writer"> 작성자 &nbsp; &nbsp; &nbsp;
	<input type="radio" name="item" value="date"> 날짜
</div>
<div id="titleDiv">
	<form action="/first/nsearch" method="post">
		<input type="hidden" name="search" value="title">
		<label>검색할 제목을 입력하시오 : <input type="search" name="keyword"></label>
		<input type="submit" value="검색">
	</form>
</div>
<div id="writerDiv">
	<form action="/first/nsearch" method="post">
		<input type="hidden" name="search" value="writer">
		<label>검색할 작성자 아이디를 입력하시오 : <input type="search" name="keyword"></label>
		<input type="submit" value="검색">
	</form>
</div>
<div id="dateDiv">
	<form action="/first/nsearch" method="post">
		<input type="hidden" name="search" value="date">
		<label>검색할 날짜를 선택하시오 : 
		<input type="date" name="from"> ~ <input type="date" name="to"></label>
		<input type="submit" value="검색">
	</form>
</div>
</center>
<br>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="1">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>첨부파일</th><th>등록날짜</th></tr>
<% for(Notice n : list){ %>
	<tr>
		<td align="center"><%= n.getNoticeNo() %></td>
		<td><a href="/first/ndetail?noticeno=<%= n.getNoticeNo() %>"><%= n.getNoticeTitle() %></a></td>
		<td><%= n.getNoticeWriter() %></td>
		<td align="center">
			<% if(n.getOriginalFilePath() != null){ //첨부파일이 있을 때 %>
			◎
			<% }else{ //첨부파일이 없을 때 %>
			&nbsp;
			<% } %>
		</td>
		<td><%= n.getNoticeDate() %></td>
	</tr>
<% } //for each %>
</table>

<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>


