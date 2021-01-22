package member.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.vo.Member;

//쿼리문 작성해서 db로 전달해서 실행하고 결과받음
//select 문은 받은 결과(ResultSet)를 vo 객체에 옮겨 저장(결과매핑)해서 리턴 처리함
public class MemberDao {
	public MemberDao() {}
	
	//로그인 처리용 메소드 : select
	public Member selectLogin(Connection conn, String userId, String userPwd) {
		Member m = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		String query = "select * from member where userid = '" + userId + "' and userpwd = '"
//						+ userPwd + "'";
		String query = "select * from member "
				+ "join users using(userid, userpwd) "
				+ "where userid = ? and userpwd = ?";
		
		try {
			//미완성된 쿼리문을 가지고 객체 먼저 생성함
			pstmt = conn.prepareStatement(query);
			//객체 생성 후에 쿼리문을 완성시킴
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			//쿼리문 실행시키고 결과 받음
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				
				m.setUserId(rset.getString("userid"));
				m.setUserPwd(rset.getString(2));
				m.setUserName(rset.getString("username"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setHobby(rset.getString("hobby"));
				m.setEtc(rset.getString("etc"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setLastModified(rset.getDate("lastmodified"));				
				m.setSqLev(rset.getString("sq_lev"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	//회원 가입 처리용 메소드 : insert
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getHobby());
			pstmt.setString(9, member.getEtc());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//회원 탈퇴 처리용 메소드 : delete
	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from member where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//회원 정보 보기 처리용 메소드 : select
	public Member selectMember(Connection conn, String userId) {
		Member m = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		String query = "select * from member where userid = '" + userId + "'";
		String query = "select * from member where userid = ?";
		
		try {
			//미완성된 쿼리문을 가지고 객체 먼저 생성함
			pstmt = conn.prepareStatement(query);
			//객체 생성 후에 쿼리문을 완성시킴
			pstmt.setString(1, userId);			
			
			//쿼리문 실행시키고 결과 받음
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				
				m.setUserId(rset.getString("userid"));
				m.setUserPwd(rset.getString(2));
				m.setUserName(rset.getString("username"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setHobby(rset.getString("hobby"));
				m.setEtc(rset.getString("etc"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setLastModified(rset.getDate("lastmodified"));				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	//회원 정보 수정 처리용 메소드 : update
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update member set userpwd = ?, phone = ?, email = ?, hobby = ?, "
				+ "age = ?, etc = ?, lastmodified = sysdate where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserPwd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getHobby());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getEtc());
			pstmt.setString(7, member.getUserId());			

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//관리자용 회원 전체 조회 처리용 메소드 : select
	public ArrayList<Member> selectList(Connection conn){
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Member m = new Member();
				
				m.setUserId(rset.getString("userid"));
				m.setUserPwd(rset.getString(2));
				m.setUserName(rset.getString("username"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setHobby(rset.getString("hobby"));
				m.setEtc(rset.getString("etc"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setLastModified(rset.getDate("lastmodified"));
								
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int selectCheckId(Connection conn, String userid) {
		int idcount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(userid) from member where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				idcount = rset.getInt(1);
				System.out.println("idcount : " + idcount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}		
		
		return idcount;
	}
}





