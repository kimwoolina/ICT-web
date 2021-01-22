<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member" %>
<%
	Member member = (Member)request.getAttribute("member");

	//취미(hobby) 값을 각각의 문자열로 분리 처리
	String[] hobbies = member.getHobby().split(",");
	
	//9개의 체크박스에 대해 checked 속성 처리를 위한 값 배열을 만듦
	String[] checked = new String[9];
	
	for(String hb : hobbies){
		switch(hb){
		case "game": checked[0] = "checked"; break;
		case "reading": checked[1] = "checked"; break;
		case "climb": checked[2] = "checked"; break;
		case "sport": checked[3] = "checked"; break;
		case "music": checked[4] = "checked"; break;
		case "movie": checked[5] = "checked"; break;
		case "travel": checked[6] = "checked"; break;
		case "cook": checked[7] = "checked"; break;
		case "etc": checked[8] = "checked"; break;
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr>
<h1 align="center">회원 정보 수정 페이지</h1>
<br>
<form action="/first/mupdate" method="post">
<table id="outer" align="center" width="500" cellspacing="5" cellpadding="0">
<tr><th width="120">이 름</th>
	<td><input type="text" name="username" value="<%= member.getUserName() %>" readonly></td>
</tr>
<tr><th width="120">아이디</th>
	<td><input type="text" name="userid" value="<%= member.getUserId() %>" readonly></td></tr>
<tr><th width="120">암 호</th>
	<td><input type="password" name="userpwd" id="userpwd1" value="<%= member.getUserPwd() %>"></td></tr>
<tr><th width="120">암호확인</th>
	<td><input type="password" id="userpwd2"></td></tr>
<tr><th width="120">성 별</th>
	<td>
	<% if(member.getGender().equals("M")){ %>
		<input type="radio" name="gender" value="M" checked> 남자 &nbsp; 
		<input type="radio" name="gender" value="F"> 여자
	<% }else{ %>
		<input type="radio" name="gender" value="M" > 남자 &nbsp; 
		<input type="radio" name="gender" value="F" checked> 여자
	<% } %>
	</td></tr>
<tr><th width="120">나 이</th>
	<td><input type="number" name="age" value="<%= member.getAge() %>" min="19" max="200"></td></tr>
<tr><th width="120">전화번호</th>
	<td><input type="tel" name="phone" value="<%= member.getPhone() %>"></td></tr>
<tr><th width="120">이메일</th>
	<td><input type="email" name="email" value="<%= member.getEmail() %>"></td></tr>
<tr><th width="120">취 미</th>
	<td>
		<table width="350">
		<tr>
			<td><input type="checkbox" name="hobby" value="game" <%= checked[0] %>> 게임</td>
			<td><input type="checkbox" name="hobby" value="reading" <%= checked[1] %>> 독서</td>
			<td><input type="checkbox" name="hobby" value="climb" <%= checked[2] %>> 등산</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="hobby" value="sport" <%= checked[3] %>> 운동</td>
			<td><input type="checkbox" name="hobby" value="music" <%= checked[4] %>> 음악듣기</td>
			<td><input type="checkbox" name="hobby" value="movie" <%= checked[5] %>> 영화보기</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="hobby" value="travel" <%= checked[6] %>> 여행</td>
			<td><input type="checkbox" name="hobby" value="cook" <%= checked[7] %>> 요리</td>
			<td><input type="checkbox" name="hobby" value="etc" <%= checked[8] %>> 기타</td>
		</tr>
		</table>	
	</td></tr>
<tr><th width="120">하고 싶은 말</th>
	<td><textarea name="etc" rows="5" cols="50"><%= member.getEtc() %></textarea></td></tr>
<tr><th width="120" colspan="2">
	<a href="javascript:history.go(-1);">이전 페이지로 이동</a> &nbsp; 
	<input type="submit" value="수정하기"> &nbsp; 
	<input type="reset" value="수정취소">
</th></tr>
</table>
</form>



<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>