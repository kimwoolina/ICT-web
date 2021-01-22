package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 처리용 컨트롤러
		//클라이언트로 부터 로그인 요청을 받아서, 전송온 아이디와 암호를 추출함
		
		//1. 전송온 값에 한글이 있다면, 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//2. 전송온 값 꺼내서 변수 또는 vo 객체에 기록 저장함
		//전송온 값(parameter)들은 모두 request 에 기록되어 전송옴
		//String 변수 = request.getParameter("input 태그의 name 속성에 설정한 이름");
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		System.out.println("확인 : " + userId + ", " + userPwd);
		
		//3. Model 의 service 클래스 객체 생성하고, 로그인 메소드 실행하고 결과받음
		/*
		 * MemberService mservice = new MemberService(); Member loginMember =
		 * mservice.selectLogin(userId, userPwd);
		 */
		Member loginMember = new MemberService().selectLogin(userId, userPwd);
		System.out.println("loginMember : " + loginMember);
		
		//4. 리턴된 결과를 가지고 성공/실패에 대한 뷰페이지를 선택해서 응답함(response)
		if(loginMember != null) {
			//로그인 성공시, 해당 클라이언트의 세션 객체를 생성함
			//WAS(톰켓)가 관리하는 sessionScope 영역에 로그인 요청한 사용자의
			//세션객체가 만들어지도록 함
			HttpSession session = request.getSession();
			System.out.println("session ID : " + session.getId());
			//필요할 경우 세션객체에 객체정보를 저장할 수도 있음. Map 방식임
			//세션레퍼런스.setAttribute("이름", 객체);
			session.setAttribute("loginMember", loginMember);
			//뷰페이지를 선택해서 내보냄
			response.sendRedirect("/first/index.jsp");
		}else {
			//로그인 실패시 에러페이지를 내보내도록 함
			//방법 1. 뷰페이지만 선택해서 내보냄, 페이지에 출력할 값을 함께 보낼수 없음
			//response.sendRedirect("/first/views/common/error.jsp");
			
			//방법 2. 내보낼 뷰페이지를 지정하고, 뷰페이지에 출력할 값도 함께 보내려면
			//getRequestDispather("상대경로로 내보낼 뷰파일지정"), 절대경로 사용 못 함
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "로그인 실패!");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("LoginServlet 클래스의 doPost() 메소드가 연결 실행됨");
		doGet(request, response);
	}

}
