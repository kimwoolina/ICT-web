<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./views/common/error.jsp" %>
<%-- errorPage 속성의 값은 상대경로만 사용할 수 있음. --%>
<%-- jsp 주석 태그임. 브라우저에서 페이지소스보기로는 안 보임 --%>
<%
	//스크립트릿(scriptlet) 태그 : jsp 가 서블릿으로 변환되었을 때, _jspService() 메소드 안의 코드가 됨
	/*
		index.jsp --> 실행시키면 톰켓에 의해서 index_jsp.java 로 변환되고 나서 컴파일됨
		index_jsp.class 가 만들어짐
	*/
	//errorPage 연결 확인을 위한 테스트 코드임.
	//String str = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
/**/
section {
	position: relative;
	left: 120px;
}
section > div {
	width: 360px;
	background: #ccffff;
	float:left; border:1px solid navy; padding:5px; margin:5px;
}
section div table { width: 350px; background: white; }
</style>
<script type="text/javascript" src="/first/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	/*
		지정된 시간간격마다 지정된 함수가 자동실행되게 하려면
		setInterval(function(){ $.ajax();  }, 시간);
		시간은 밀리세컨드임 : 1000 이 1초임
	*/
	/* setInterval(function(){
		console.log("setInterval() 에 의해 자동 실행 확인.");
	}, 100); */
	
	//최근 등록된 신규 공지글 3개 조회 출력되게 함
	$.ajax({
		url: "/first/ntop3",
		type: "get",
		dataType: "json",
		success: function(data){
			console.log("success : " + data);
			
			//object ==> string 으로 변환
			var jsonStr = JSON.stringify(data);
			//string ==> json 객체로 바꿈
			var json = JSON.parse(jsonStr);
			
			var values = "";
			for(var i in json.list){
				values += "<tr><td>" + json.list[i].no
						+ "</td><td><a href='/first/ndetail?noticeno="
						+ json.list[i].no + "'>"
						+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ")
						+ "</a></td><td>" + json.list[i].date + "</td></tr>";
			} //for in
			
			$("#newnotice").html($("#newnotice").html() + values);
		},
		error: function(jqXHR, textstatus, errorthrown){
			console.log("error : " + jqXHR + ", " + textstatus + ", "
					+ errorthrown);
		}
	});
	
	//조회수 많은 인기 게시 원글 상위 3개 조회 출력되게 함
	$.ajax({
		url: "/first/btop3",
		type: "get",
		dataType: "json",
		success: function(data){
			//object ==> string 으로 변환
			var jsonStr = JSON.stringify(data);
			//string ==> json 객체로 바꿈
			var json = JSON.parse(jsonStr);
			
			var values = "";
			for(var i in json.list){
				values += "<tr><td>" + json.list[i].bnum
						+ "</td><td><a href='/first/bdetail?bnum="
						+ json.list[i].bnum + "'>"
						+ decodeURIComponent(json.list[i].btitle).replace(/\+/gi, " ")
						+ "</a></td><td>" + json.list[i].rcount + "</td></tr>";
			} //for in
			
			$("#topboard").html($("#topboard").html() + values);
		},
		error: function(jqXHR, textstatus, errorthrown){
			console.log("error : " + jqXHR + ", " + textstatus + ", "
					+ errorthrown);
		}
	});
	
});  //jQuery(document).ready(function(){});
</script>
</head>
<body>
<!-- html 주석 태그임. 브라우저에서 페이지소스보기 했을 때 보여짐 -->
<!-- <h1>first web project Test : welcome!</h1> -->
<%-- 에러 테스트용 출력 : <%= str.toUpperCase() %> --%>
<%@ include file="./views/common/header.jsp" %>
<hr>
<section>
<%-- 최근 등록된 공지글 3개 출력 : ajax --%>
<div>
	<h4>신규 공지사항</h4>
	<table id="newnotice" border="1" cellspacing="0">
	<tr><th>번호</th><th>제목</th><th>날짜</th></tr>
	</table>
</div>
<%-- 조회수 많은 인기 게시글 3개 출력 : ajax --%>
<div>
	<h4>인기 게시글</h4>
	<table id="topboard" border="1" cellspacing="0">
	<tr><th>번호</th><th>제목</th><th>조회수</th></tr>
	</table>
</div>
</section>
<br style="clear:both;">
<hr>
<%@ include file="./views/common/footer.jsp" %>
<%-- include 지시자의 file 속성의 값은 상대경로만 사용할 수 있음 --%>
</body>
</html>