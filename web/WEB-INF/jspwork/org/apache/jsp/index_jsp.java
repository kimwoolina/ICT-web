/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2020-12-23 03:02:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/./views/common/footer.jsp", Long.valueOf(1607581377049L));
    _jspx_dependants.put("/./views/common/header.jsp", Long.valueOf(1608627211456L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"./views/common/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

	//스크립트릿(scriptlet) 태그 : jsp 가 서블릿으로 변환되었을 때, _jspService() 메소드 안의 코드가 됨
	/*
		index.jsp --> 실행시키면 톰켓에 의해서 index_jsp.java 로 변환되고 나서 컴파일됨
		index_jsp.class 가 만들어짐
	*/
	//errorPage 연결 확인을 위한 테스트 코드임.
	//String str = null;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>first</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("/**/\r\n");
      out.write("section {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tleft: 120px;\r\n");
      out.write("}\r\n");
      out.write("section > div {\r\n");
      out.write("\twidth: 360px;\r\n");
      out.write("\tbackground: #ccffff;\r\n");
      out.write("\tfloat:left; border:1px solid navy; padding:5px; margin:5px;\r\n");
      out.write("}\r\n");
      out.write("section div table { width: 350px; background: white; }\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/first/resources/js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t/*\r\n");
      out.write("\t\t지정된 시간간격마다 지정된 함수가 자동실행되게 하려면\r\n");
      out.write("\t\tsetInterval(function(){ $.ajax();  }, 시간);\r\n");
      out.write("\t\t시간은 밀리세컨드임 : 1000 이 1초임\r\n");
      out.write("\t*/\r\n");
      out.write("\t/* setInterval(function(){\r\n");
      out.write("\t\tconsole.log(\"setInterval() 에 의해 자동 실행 확인.\");\r\n");
      out.write("\t}, 100); */\r\n");
      out.write("\t\r\n");
      out.write("\t//최근 등록된 신규 공지글 3개 조회 출력되게 함\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl: \"/first/ntop3\",\r\n");
      out.write("\t\ttype: \"get\",\r\n");
      out.write("\t\tdataType: \"json\",\r\n");
      out.write("\t\tsuccess: function(data){\r\n");
      out.write("\t\t\tconsole.log(\"success : \" + data);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//object ==> string 으로 변환\r\n");
      out.write("\t\t\tvar jsonStr = JSON.stringify(data);\r\n");
      out.write("\t\t\t//string ==> json 객체로 바꿈\r\n");
      out.write("\t\t\tvar json = JSON.parse(jsonStr);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar values = \"\";\r\n");
      out.write("\t\t\tfor(var i in json.list){\r\n");
      out.write("\t\t\t\tvalues += \"<tr><td>\" + json.list[i].no\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td><a href='/first/ndetail?noticeno=\"\r\n");
      out.write("\t\t\t\t\t\t+ json.list[i].no + \"'>\"\r\n");
      out.write("\t\t\t\t\t\t+ decodeURIComponent(json.list[i].title).replace(/\\+/gi, \" \")\r\n");
      out.write("\t\t\t\t\t\t+ \"</a></td><td>\" + json.list[i].date + \"</td></tr>\";\r\n");
      out.write("\t\t\t} //for in\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#newnotice\").html($(\"#newnotice\").html() + values);\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror: function(jqXHR, textstatus, errorthrown){\r\n");
      out.write("\t\t\tconsole.log(\"error : \" + jqXHR + \", \" + textstatus + \", \"\r\n");
      out.write("\t\t\t\t\t+ errorthrown);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//조회수 많은 인기 게시 원글 상위 3개 조회 출력되게 함\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl: \"/first/btop3\",\r\n");
      out.write("\t\ttype: \"get\",\r\n");
      out.write("\t\tdataType: \"json\",\r\n");
      out.write("\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t//object ==> string 으로 변환\r\n");
      out.write("\t\t\tvar jsonStr = JSON.stringify(data);\r\n");
      out.write("\t\t\t//string ==> json 객체로 바꿈\r\n");
      out.write("\t\t\tvar json = JSON.parse(jsonStr);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar values = \"\";\r\n");
      out.write("\t\t\tfor(var i in json.list){\r\n");
      out.write("\t\t\t\tvalues += \"<tr><td>\" + json.list[i].bnum\r\n");
      out.write("\t\t\t\t\t\t+ \"</td><td><a href='/first/bdetail?bnum=\"\r\n");
      out.write("\t\t\t\t\t\t+ json.list[i].bnum + \"'>\"\r\n");
      out.write("\t\t\t\t\t\t+ decodeURIComponent(json.list[i].btitle).replace(/\\+/gi, \" \")\r\n");
      out.write("\t\t\t\t\t\t+ \"</a></td><td>\" + json.list[i].rcount + \"</td></tr>\";\r\n");
      out.write("\t\t\t} //for in\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#topboard\").html($(\"#topboard\").html() + values);\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror: function(jqXHR, textstatus, errorthrown){\r\n");
      out.write("\t\t\tconsole.log(\"error : \" + jqXHR + \", \" + textstatus + \", \"\r\n");
      out.write("\t\t\t\t\t+ errorthrown);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});  //jQuery(document).ready(function(){});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- html 주석 태그임. 브라우저에서 페이지소스보기 했을 때 보여짐 -->\r\n");
      out.write("<!-- <h1>first web project Test : welcome!</h1> -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

	Member loginMember = (Member)session.getAttribute("loginMember");

      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("header ul#menubar { list-style : none;  }\r\n");
      out.write("header ul#menubar li {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 120px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tmargin-right: 5px;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("header ul#menubar li a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\twidth: 120px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding-top: 5px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tbackground: orange;\r\n");
      out.write("\tcolor: navy;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\ttext-shadow: 1px 1px 2px white;\r\n");
      out.write("}\r\n");
      out.write("hr { clear: both; }\r\n");
      out.write("section table#loginTbl {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("\tbackground: lightgray;\r\n");
      out.write("\twidth: 280px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("<h1>first</h1>\r\n");
 if(loginMember != null && loginMember.getSqLev().charAt(0) < 'C'){  //관리자일때 
      out.write("\r\n");
      out.write("<ul id=\"menubar\">\r\n");
      out.write("\t<li><a href=\"/first/index.jsp\">홈</a></li>\r\n");
      out.write("\t<li><a href=\"/first/nlist\">공지사항관리</a></li>\r\n");
      out.write("\t<li><a href=\"/first/blist?page=1\">게시글관리</a></li>\r\n");
      out.write("\t<li><a href=\"#\">회원관리</a></li>\r\n");
      out.write("\t<li><a href=\"#\">#</a></li>\r\n");
      out.write("</ul>\r\n");
 }else{ //관리자가 아닐 때 
      out.write("\r\n");
      out.write("<ul id=\"menubar\">\r\n");
      out.write("\t<li><a href=\"/first/index.jsp\">홈</a></li>\r\n");
      out.write("\t<li><a href=\"/first/nlist\">공지사항</a></li>\r\n");
      out.write("\t<li><a href=\"/first/blist?page=1\">게시글</a></li>\r\n");
      out.write("\t<li><a href=\"#\">#</a></li>\r\n");
      out.write("\t<li><a href=\"#\">#</a></li>\r\n");
      out.write("</ul>\r\n");
 } 
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("<hr>\r\n");
      out.write("<section>\r\n");
 if(loginMember == null){ //로그인 안 했다면 
      out.write("\r\n");
      out.write("<form action=\"/first/login\" method=\"post\">\r\n");
      out.write("<table id=\"loginTbl\" width=\"250\">\r\n");
      out.write("\t<tr><th>아이디</th><td><input type=\"text\" name=\"userid\"></td></tr>\r\n");
      out.write("\t<tr><th>암 호</th><td><input type=\"password\" name=\"userpwd\"></td></tr>\r\n");
      out.write("\t<tr><th colspan=\"2\"><input type=\"submit\" value=\"로그인\"> &nbsp; \r\n");
      out.write("\t   <a href=\"/first/views/member/memberEnroll.jsp\">회원가입</a></th></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
 }else{ //로그인했다면
      out.write("\r\n");
      out.write("<table id=\"loginTbl\" width=\"250\">\r\n");
      out.write("\t<tr><th>");
      out.print( loginMember.getUserName() );
      out.write(" 님</th>\r\n");
      out.write("\t<td><a href=\"/first/logout\">로그아웃</a></td></tr>\r\n");
      out.write("\t<tr><th><a href=\"/first/views/member/memberDetailView.jsp\">내정보보기</a></th>\r\n");
      out.write("\t<td>쪽지</td></tr>\r\n");
      out.write("\t<tr><th colspan=\"2\">메일</th></tr>\r\n");
      out.write("</table>\r\n");
 } 
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<hr>\r\n");
      out.write("<section>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\t<h4>신규 공지사항</h4>\r\n");
      out.write("\t<table id=\"newnotice\" border=\"1\" cellspacing=\"0\">\r\n");
      out.write("\t<tr><th>번호</th><th>제목</th><th>날짜</th></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\t<h4>인기 게시글</h4>\r\n");
      out.write("\t<table id=\"topboard\" border=\"1\" cellspacing=\"0\">\r\n");
      out.write("\t<tr><th>번호</th><th>제목</th><th>조회수</th></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("</section>\r\n");
      out.write("<br style=\"clear:both;\">\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("footer {\r\n");
      out.write("\tbackground : gray;\r\n");
      out.write("\ttext-align : center;\r\n");
      out.write("\twidth : 100%;\r\n");
      out.write("\theight : 60px;\r\n");
      out.write("\tfont-size : 0.8em;\r\n");
      out.write("\tfont-weight : bold;\r\n");
      out.write("\tpadding-top : 10px;\r\n");
      out.write("\ttext-shadow: 1px 1px 2px white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("hr { clear : both; }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<footer>\r\n");
      out.write("copyright@ict.or.kr &nbsp; 관리자 메일 : master@ict.or.kr &nbsp; 2020-12-10 <br>\r\n");
      out.write("Tel : 02-12345678, Fax : 02-1234-5679\r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}