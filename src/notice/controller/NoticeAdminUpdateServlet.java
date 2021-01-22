package notice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeAdminUpdateServlet
 */
@WebServlet("/nupdate.ad")
public class NoticeAdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeAdminUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 관리자용 공지사항 수정 처리용 컨트롤러

		// 1. multipart 방식으로 인코딩되어서 전송되었는지 확인함
		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			// multipart 로 파일업로드 처리가 안 되었다면
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form의 enctype='multipart/form-data' 속성 누락되었음. 확인하세요.");
			view.forward(request, response);
		}

		// 2. 업로드할 파일의 용량 제한 설정 : 10Mbyte 로 제한한다면
		int maxSize = 1024 * 1024 * 10;

		// 3. 업로드되는 파일의 저장 폴더 지정하기
		String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_files");

		// 4. request를 MultipartRequest 로 변환해야 함
		// cos.jar 가 제공하는 클래스를 사용함
		// 자동으로 지정한 폴더에 파일이 저장됨(업로드 완료됨)
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		// 5. 전송 온 값 꺼내서 변수 또는 VO 객체에 기록 저장
		// 주의 : mrequest 로 추출해야 함 (request 로는 값 추출 안 됨, null 임)
		Notice notice = new Notice();
		notice.setNoticeNo(Integer.parseInt(mrequest.getParameter("no")));
		notice.setNoticeTitle(mrequest.getParameter("title"));
		notice.setNoticeWriter(mrequest.getParameter("writer"));
		notice.setNoticeContent(mrequest.getParameter("content"));
		
		//이전 등록된 파일 삭제 여부 값 추출함
		String deleteFlag = mrequest.getParameter("deleteFlag");
		//이전 등록된 파일명 추출함
		String originFilePath = mrequest.getParameter("ofile");
		String renameFilePath = mrequest.getParameter("rfile");
		
		//새로운 첨부파일명 추출하기
		String originalFileName = mrequest.getFilesystemName("upfile");
		
		//수정경우 1.
		//원래 파일과 새로 업로드된 파일의 이름이 같고,
		//파일 용량도 동일하면 원래 이름 그대로 객체에 기록함
		
		//새로 업로드된 파일의 File 객체 만들기
		File newOriginFile = new File(savePath + "/" + originalFileName);
		//이전 저장된 파일의 File 객체 만들기
		File originFile = new File(savePath + "/" + renameFilePath);

		//수정경우 2.
		//첨부파일이 없었는데 추가된 경우와
		//첨부파일이 있었는데 변경된 경우 둘 다 이름바꾸기 실행함
		if (originalFileName != null) {
			//새로 첨부된 또는 변경되어 업로드된 파일명을 vo 에 기록함
			notice.setOriginalFilePath(originalFileName);
			
			// 바꿀 파일명에 대한 포맷문자열 만들기 : 년월일시분초 형식으로
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

			// 바꿀 파일명 만들기
			String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()));

			// 업로드된 파일의 확장자를 추출해서, 새 파일명에 붙임
			renameFileName += "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

			// 저장된 원본파일명을 rename 하기 위해 File 객체 만듦			
			File renameFile = new File(savePath + "\\" + renameFileName);

			// 이름 바꾸기 실행함
			if (!newOriginFile.renameTo(renameFile)) { // 파일 이름바꾸기 실패했다면
				// 직접 바꾸는 코드 작성함
				// 업로드된 원본 파일(originFile)의 내용을 읽어서(read),
				// renameFile 에 기록함(write)
				// originFile 삭제함
				FileInputStream fin = new FileInputStream(newOriginFile);
				FileOutputStream fout = new FileOutputStream(renameFile);
				int data = -1;
				byte[] buffer = new byte[1024];

				while ((data = fin.read(buffer, 0, buffer.length)) != -1) {
					fout.write(buffer, 0, buffer.length);
				}

				fin.close();
				fout.close();
				newOriginFile.delete(); // 원본 파일 삭제함
			} // file rename failed...

			notice.setRenameFilePath(renameFileName);
			
			//이전 첨부파일이 있었다면 이전파일도 삭제함
			if(originFilePath != null) {
				originFile.delete();  //폴더에 저장된 이전파일 삭제함
			}
		}else if(originFilePath != null && 
				deleteFlag != null && deleteFlag.equals("yes")) {
			//원래 첨부파일이 있었는데, 파일삭제가 선택된 경우
			notice.setOriginalFilePath(null);
			notice.setRenameFilePath(null);
			
			//폴더에 저장된 파일도 삭제함
			originFile.delete();
		}else if(originFilePath != null && 
				(originalFileName == null || originFilePath.equals(originalFileName)
				 && newOriginFile.length() == originFile.length())) {
			//원래 첨부파일이 있었는데, 변경되지 않은 경우
			//파일명이 같고, 파일용량도 같은 경우
			notice.setOriginalFilePath(originFilePath);
			notice.setRenameFilePath(renameFilePath);
		}

		// 6. 모델의 서비스 객체 생성하고, 메소드 실행하고 결과받기
		int result = new NoticeService().updateNotice(notice);

		// 7. 받은 결과를 가지고 성공/실패에 대한 뷰를 선택해서 내보냄
		if (result > 0) { // 공지글 등록이 성공했다면
			response.sendRedirect("/first/nlist");
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", 
					notice.getNoticeNo() + " 번 공지사항 수정 실패!");
			view.forward(request, response);
		}
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
