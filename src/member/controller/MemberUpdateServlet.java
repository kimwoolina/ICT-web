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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 수정 처리용 컨트롤러
		//1. 전송온 값에 한글이 있다면, 인코딩 처리함
		request.setCharacterEncoding("UTF-8");  //전송보낸 뷰페이지의 문자셋으로 지정
		
		//2. 전송온 값 꺼내서 변수 또는 vo 객체에 기록 저장
		Member member = new Member();
		//String 변수 = request.getParameter("input의 name");
		member.setUserId(request.getParameter("userid"));
		member.setUserPwd(request.getParameter("userpwd"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setEtc(request.getParameter("etc"));
		
		//하나의 이름으로 여러개의 값이 전송온 경우 : checkbox
		//String[] 배열레퍼런스 = request.getParameterValues("이름");
		//String[] hobbies = request.getParameterValues("hobby");
		//String[] 을 String 으로 변환하려면
		//String hobby = String.join(",", hobbies);
		member.setHobby(String.join(",", request.getParameterValues("hobby")));
		
		System.out.println("member : " + member);
		
		//3. 모델 서비스 객체 생성하고, 메소드 실행시키고 결과 받기
		int result = new MemberService().updateMember(member);
		
		//4. 받은 결과에 따라 성공/실패 페이지를 선택해서 내보냄
		if(result > 0) {
			//수정항목 추출에서 제외된 전송값 추출해서 member 에 기록 저장함			
			member.setUserName(request.getParameter("username"));
			member.setGender(request.getParameter("gender"));
			
			//세션 객체의 저장된 회원정보를 수정된 새 정보로 바꿈
			HttpSession session = request.getSession(false);
			session.setAttribute("loginMember", member);
			
			//수정 성공시 '내정보보기' 페이지를 내보냄
			response.sendRedirect("/first/views/member/memberDetailView.jsp");
		}else {
			//수정 실패시 에러 페이지와 메세지를 내보냄
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", member.getUserId() + " 회원의 정보 수정 실패!");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
