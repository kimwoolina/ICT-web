/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2020-12-15 03:44:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class noticeWriteForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/notice/../common/header.jsp", Long.valueOf(1607996916266L));
    _jspx_dependants.put("/views/notice/../common/footer.jsp", Long.valueOf(1607581377049L));
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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>first</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
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
      out.write("\t<li><a href=\"#\">게시글관리</a></li>\r\n");
      out.write("\t<li><a href=\"#\">회원관리</a></li>\r\n");
      out.write("\t<li><a href=\"#\">#</a></li>\r\n");
      out.write("</ul>\r\n");
 }else{ //관리자가 아닐 때 
      out.write("\r\n");
      out.write("<ul id=\"menubar\">\r\n");
      out.write("\t<li><a href=\"/first/index.jsp\">홈</a></li>\r\n");
      out.write("\t<li><a href=\"/first/nlist\">공지사항</a></li>\r\n");
      out.write("\t<li><a href=\"#\">게시글</a></li>\r\n");
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
      out.write("<h1 align=\"center\">새 공지글 등록 페이지</h1>\r\n");
      out.write("\r\n");
      out.write("<form action=\"/first/ninsert.ad\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("<!-- <form action=\"/first/ninsert.ad\" method=\"post\"> -->\r\n");
      out.write("<table align=\"center\" width=\"500\" border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\r\n");
      out.write("<tr><th>제 목</th><td><input type=\"text\" name=\"title\" size=\"50\"></td></tr>\r\n");
      out.write("<tr><th>작성자</th>\r\n");
      out.write("<td><input type=\"text\" name=\"writer\" readonly value=\"");
      out.print( loginMember.getUserId() );
      out.write("\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr><th>파일 선택</th><td><input type=\"file\" name=\"ofile\"></td></tr>\r\n");
      out.write("<tr><th>내 용</th><td><textarea rows=\"5\" cols=\"50\" name=\"content\"></textarea></td></tr>\r\n");
      out.write("<tr><th colspan=\"2\">\r\n");
      out.write("\t<input type=\"submit\" value=\"등록하기\"> &nbsp; \r\n");
      out.write("\t<input type=\"reset\" value=\"작성취소\"> &nbsp; \r\n");
      out.write("\t<input type=\"button\" value=\"목록\" onclick=\"javascript:history.go(-1); return false;\"></th></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
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
