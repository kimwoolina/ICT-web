package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollServlet
 */
@WebServlet("/enroll")
public class MemberEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 처리용 컨트롤러
		//1. 전송온 값에 한글이 있다면 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//2. 전송온 값 꺼내서 변수 또는 vo 객체에 기록 저장함
		Member member = new Member();
		member.setUserId(request.getParameter("userid"));
		member.setUserPwd(request.getParameter("userpwd"));
		member.setUserName(request.getParameter("username"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setGender(request.getParameter("gender"));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setEtc(request.getParameter("etc"));
		
		//같은 이름으로 여러 개의 값이 전송온 경우
		//hobby=game&hobby=climb&hobby=sports
		//String[] 배열레퍼런스 = request.getParameterValues("이름");
		//db 의 테이블의 컬럼값 기록형태가 하나의 문자열이므로
		//String[] ==> String : join() 메소드 사용
		member.setHobby(String.join(",", request.getParameterValues("hobby")));
		
		//3. 모델의 서비스 객체 생성하고, 메소드 실행해서 처리 결과받기
		int result = new MemberService().insertMember(member);
		
		//4. 받은 결과에 따라 성공/실패 페이지를 선택해서 내보냄
		if(result > 0) {
			response.sendRedirect("/first/index.jsp");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "회원 가입 실패!");
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
