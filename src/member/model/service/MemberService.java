package member.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;

//db 연결/닫기, 트랜잭션 관리 : commit/rollback 전담하는 클래스
//뷰파일 --> 컨트롤러 --> service --> dao
public class MemberService {
	//의존성 주입(Dependency Injection : DI)
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}
	
	//로그인 처리용
	public Member selectLogin(String userId, String userPwd) {
		Connection conn = getConnection();
		Member member = mdao.selectLogin(conn, userId, userPwd);
		close(conn);
		return member;
	}
	
	//회원가입 처리용
	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = mdao.insertMember(conn, member);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	//회원탈퇴 처리용
	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = mdao.deleteMember(conn, userId);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	//회원정보 수정 처리용
	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = mdao.updateMember(conn, member);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	//회원정보 조회 처리용
	public Member selectMember(String userId) {
		Connection conn = getConnection();
		Member member = mdao.selectMember(conn, userId);
		close(conn);
		return member;
	}
	
	//관리자용 전체 회원 조회 처리용
	public ArrayList<Member> selectList(){
		Connection conn = getConnection();
		ArrayList<Member> list = mdao.selectList(conn);
		close(conn);
		return list;
	}

	public int selectCheckId(String userid) {
		Connection conn = getConnection();
		int idcount = mdao.selectCheckId(conn, userid);
		close(conn);
		return idcount;
	}
}
