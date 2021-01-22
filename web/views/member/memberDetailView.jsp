<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr>
<section>
<h2 align="center">내 정보 보기 페이지</h2>
<br>
<table id="outer" align="center" width="500" cellspacing="5" cellpadding="0">
<tr><th width="120">이 름</th><td><%= loginMember.getUserName() %></td></tr>
<tr><th width="120">아이디</th><td><%= loginMember.getUserId() %></td></tr>
<tr><th width="120">암 호</th><td><%= loginMember.getUserPwd() %></td></tr>
<tr><th width="120">성 별</th><td><%= loginMember.getGender() %></td></tr>
<tr><th width="120">나 이</th><td><%= loginMember.getAge() %></td></tr>
<tr><th width="120">전화번호</th><td><%= loginMember.getPhone() %></td></tr>
<tr><th width="120">이메일</th><td><%= loginMember.getEmail() %></td></tr>
<tr><th width="120">취 미</th><td><%= loginMember.getHobby() %></td></tr>
<tr><th width="120">하고 싶은 말</th><td><%= loginMember.getEtc() %></td></tr>
<tr><th width="120" colspan="2">
	<button onclick="moveUpdateView();">수정 페이지로 이동</button> &nbsp; 
	<button onclick="sendDelete();">탈퇴하기</button>	
</th></tr>
<script type="text/javascript">
function moveUpdateView(){
	//요청한 회원의 정보를 조회해서 수정페이지를 내보내는 서블릿을 요청함
	//회원의 아이디를 전송함
	//html <a href="연결대상"> == javascript : location.href = "연결대상";
	//연결대상으로 값도 전송할 경우, 쿼리 스트링(Query String)을 이용함
	//쿼리스트링 : ?전송이름=값&전송이름=값
	//전송값에 Expression Tag 사용할 수 있음
	location.href = "/first/mupview?userid=<%= loginMember.getUserId() %>";
}

function sendDelete(){
	//탈퇴는 삭제처리함
	//요청한 회원의 아이디를 탈퇴 처리하는 서블릿으로 전송해서 회원 테이블에서 삭제 처리함
	location.href = "/first/mdel?userid=<%= loginMember.getUserId() %>";
}
</script>
</table>
</section>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>