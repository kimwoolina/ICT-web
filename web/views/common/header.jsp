<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member" %>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
header ul#menubar { list-style : none;  }
header ul#menubar li {
	float: left;
	width: 120px;
	height: 30px;
	margin-right: 5px;
	padding: 0;
}
header ul#menubar li a {
	text-decoration: none;
	width: 120px;
	height: 30px;
	display: block;
	margin: 0;
	padding-top: 5px;
	text-align: center;
	background: orange;
	color: navy;
	font-weight: bold;
	text-shadow: 1px 1px 2px white;
}
hr { clear: both; }
section table#loginTbl {
	float: right;
	border: 1px solid black;
	background: lightgray;
	width: 280px;
}
</style>
</head>
<body>
<header>
<h1>first</h1>
<% if(loginMember != null && loginMember.getSqLev().charAt(0) < 'C'){  //관리자일때 %>
<ul id="menubar">
	<li><a href="/first/index.jsp">홈</a></li>
	<li><a href="/first/nlist">공지사항관리</a></li>
	<li><a href="/first/blist?page=1">게시글관리</a></li>
	<li><a href="#">회원관리</a></li>
	<li><a href="#">#</a></li>
</ul>
<% }else{ //관리자가 아닐 때 %>
<ul id="menubar">
	<li><a href="/first/index.jsp">홈</a></li>
	<li><a href="/first/nlist">공지사항</a></li>
	<li><a href="/first/blist?page=1">게시글</a></li>
	<li><a href="#">#</a></li>
	<li><a href="#">#</a></li>
</ul>
<% } %>
</header>
<hr>
<section>
<% if(loginMember == null){ //로그인 안 했다면 %>
<form action="/first/login" method="post">
<table id="loginTbl" width="250">
	<tr><th>아이디</th><td><input type="text" name="userid"></td></tr>
	<tr><th>암 호</th><td><input type="password" name="userpwd"></td></tr>
	<tr><th colspan="2"><input type="submit" value="로그인"> &nbsp; 
	   <a href="/first/views/member/memberEnroll.jsp">회원가입</a></th></tr>
</table>
</form>
<% }else{ //로그인했다면%>
<table id="loginTbl" width="250">
	<tr><th><%= loginMember.getUserName() %> 님</th>
	<td><a href="/first/logout">로그아웃</a></td></tr>
	<tr><th><a href="/first/views/member/memberDetailView.jsp">내정보보기</a></th>
	<td>쪽지</td></tr>
	<tr><th colspan="2">메일</th></tr>
</table>
<% } %>
</section>
</body>
</html>





