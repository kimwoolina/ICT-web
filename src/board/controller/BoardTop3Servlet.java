package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.model.service.BoardService;
import board.model.vo.Board;
import notice.model.vo.Notice;

/**
 * Servlet implementation class BoardTop3Servlet
 */
@WebServlet("/btop3")
public class BoardTop3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardTop3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ajax 통신으로 조회수 많은 인기 게시 원글 3개 조회 응답 처리용 컨트롤러

		ArrayList<Board> list = new BoardService().selectTop3();

		// 전송용 json 객체 만들기
		JSONObject sendJSON = new JSONObject();
		// list 옮겨 담을 json 배열 객체 만들기
		JSONArray jarr = new JSONArray();

		// list 에서 notice 하나씩 꺼내서 jarr 에 옮기기
		for (Board board : list) {
			// notice 저장용 json 객체 만들기
			JSONObject job = new JSONObject();
			job.put("bnum", board.getBoardNum());
			// 한글 깨짐 막으려면 반드시 인코딩 처리함
			job.put("btitle", URLEncoder.encode(board.getBoardTitle(), "utf-8"));
			// 날짜 데이터는 전송안됨, 문자열로 바꿔야 함
			job.put("rcount", board.getBoardReadCount());

			jarr.add(job);
		}

		// json 배열을 전송용 객체에 저장하기
		sendJSON.put("list", jarr);

		// 요청자에게 응답 내보내기
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(sendJSON.toJSONString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
